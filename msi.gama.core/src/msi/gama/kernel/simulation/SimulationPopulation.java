/*********************************************************************************************
 *
 *
 * 'SimulationPopulation.java', in plugin 'msi.gama.core', is part of the source code of the
 * GAMA modeling and simulation platform.
 * (c) 2007-2014 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://code.google.com/p/gama-platform/ for license information and developers contact.
 *
 *
 **********************************************************************************************/
package msi.gama.kernel.simulation;

import java.util.*;
import java.util.concurrent.*;
import com.google.common.util.concurrent.*;
import msi.gama.common.GamaPreferences;
import msi.gama.common.interfaces.IKeyword;
import msi.gama.kernel.experiment.ExperimentAgent;
import msi.gama.metamodel.agent.IAgent;
import msi.gama.metamodel.population.GamaPopulation;
import msi.gama.metamodel.shape.*;
import msi.gama.metamodel.topology.AbstractTopology.RootTopology;
import msi.gama.metamodel.topology.continuous.AmorphousTopology;
import msi.gama.runtime.IScope;
import msi.gama.runtime.exceptions.GamaRuntimeException;
import msi.gama.util.IList;
import msi.gaml.descriptions.ModelDescription;
import msi.gaml.expressions.IExpression;
import msi.gaml.operators.Cast;
import msi.gaml.species.ISpecies;

public class SimulationPopulation extends GamaPopulation {

	final ThreadFactory factory = new ThreadFactoryBuilder().setThreadFactory(Executors.defaultThreadFactory())
		.setNameFormat("Simulation thread #%d of experiment " + getSpecies().getName()).build();
	ExecutorService executor;
	Map<SimulationAgent, Callable> runnables = new LinkedHashMap();

	public SimulationPopulation(final ExperimentAgent agent, final ISpecies species) {
		super(agent, species);

	}

	protected ExecutorService getExecutorService() {
		if ( executor == null ) {
			boolean isMultiThreaded = getHost().getSpecies().isMulticore();
			int numberOfThreads = GamaPreferences.NUMBERS_OF_THREADS.getValue();
			executor = isMultiThreaded ? Executors.newFixedThreadPool(numberOfThreads, factory)
				: MoreExecutors.sameThreadExecutor();
			if ( executor instanceof ThreadPoolExecutor ) {
				ThreadPoolExecutor tpe = (ThreadPoolExecutor) executor;
				tpe.setKeepAliveTime(10, TimeUnit.SECONDS);
				tpe.allowCoreThreadTimeOut(true);

			}
		}
		return executor;
	}

	/**
	 * Method fireAgentRemoved()
	 * @see msi.gama.metamodel.population.GamaPopulation#fireAgentRemoved(msi.gama.metamodel.agent.IAgent)
	 */
	@Override
	protected void fireAgentRemoved(final IAgent agent) {
		super.fireAgentRemoved(agent);
		runnables.remove(agent);
	}

	@Override
	public void initializeFor(final IScope scope) {
		super.initializeFor(scope);
		this.currentAgentIndex = 0;
	}

	@Override
	public void dispose() {
		if ( executor != null ) {
			executor.shutdown();
			try {
				executor.awaitTermination(1, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			executor = null;
		}
		super.dispose();
	}

	@Override
	public IList<? extends IAgent> createAgents(final IScope scope, final int number,
		final List<? extends Map> initialValues, final boolean toBeScheduled) throws GamaRuntimeException {
		scope.getGui().waitStatus("Initializing simulation");
		final SimulationAgent world = new SimulationAgent(this);
		world.setIndex(currentAgentIndex++);
		world.setScheduled(toBeScheduled);
		world.setName("Simulation #" + world.getIndex() + " of model " +
			getSpecies().getName().replace(ModelDescription.MODEL_SUFFIX, ""));
		add(world);
		getHost().setSimulation(world);
		if ( scope.interrupted() ) { return null; }
		scope.getGui().waitStatus("Instantiating agents");
		createVariablesFor(world.getScope(), Collections.singletonList(world), initialValues);
		if ( toBeScheduled ) {
			world.schedule(scope);
			runnables.put(world, new Callable<Object>() {

				@Override
				public Object call() {
					return world._step_(scope);
				}
			});
		}
		return this;
	}

	@Override
	public ExperimentAgent getHost() {
		return (ExperimentAgent) super.getHost();
	}

	@Override
	public IAgent getAgent(final IScope scope, final ILocation value) {
		return get(null, 0);
	}

	public void setHost(final ExperimentAgent agent) {
		host = agent;
	}

	public void setTopology(final IScope scope, final IShape shape) {
		IExpression expr = species.getFacet(IKeyword.TORUS);
		final boolean torus = expr == null ? false : Cast.as(expr.value(scope), Boolean.class, false);
		topology = new RootTopology(scope, shape, torus);
	}

	@Override
	public void computeTopology(final IScope scope) throws GamaRuntimeException {
		// Temporary topology set before the world gets a shape
		topology = new AmorphousTopology();
	}

	@Override
	public boolean step(final IScope scope) throws GamaRuntimeException {
		try {
			getExecutorService().invokeAll((Collection<? extends Callable<Object>>) runnables.values());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * This method can be called by the batch experiments to temporarily stop (unschedule) a simulation
	 * @param sim
	 */
	public void unscheduleSimulation(final SimulationAgent sim) {
		runnables.remove(sim);
	}

	public int getNumberOfActiveThreads() {
		if ( getExecutorService() instanceof ThreadPoolExecutor ) {
			ThreadPoolExecutor e = (ThreadPoolExecutor) executor;
			return e.getPoolSize();
		}
		return 0;
	}

	/**
	 * @return
	 */
	public boolean hasScheduledSimulations() {
		return runnables.size() > 0;
	}

}