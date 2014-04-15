/*********************************************************************************************
 * 
 *
 * 'HeadlessListener.java', in plugin 'msi.gama.headless', is part of the source code of the 
 * GAMA modeling and simulation platform.
 * (c) 2007-2014 UMI 209 UMMISCO IRD/UPMC & Partners
 * 
 * Visit https://code.google.com/p/gama-platform/ for license information and developers contact.
 * 
 * 
 **********************************************************************************************/
package msi.gama.headless.runtime;

import java.util.*;
import java.util.logging.Logger;
import msi.gama.common.interfaces.*;
import msi.gama.common.util.GuiUtils;
import msi.gama.kernel.experiment.IExperimentSpecies;
import msi.gama.kernel.simulation.SimulationAgent;
import msi.gama.metamodel.agent.IAgent;
import msi.gama.outputs.*;
import msi.gama.runtime.IScope;
import msi.gama.runtime.exceptions.GamaRuntimeException;
import msi.gaml.architecture.user.UserPanelStatement;
import msi.gaml.compilation.GamaClassLoader;
import msi.gaml.types.IType;
import org.eclipse.core.runtime.*;

public class HeadlessListener implements IGui {

	static {
		if ( GuiUtils.isInHeadLessMode() ) {
			Logger.getAnonymousLogger().finest("Configuring Headless Mode");
			// System.out.println("Configuring Headless Mode");
			GuiUtils.setSwtGui(new HeadlessListener());
		}
	}

	@Override
	public Map<String, Object> openUserInputDialog(final String title, final Map<String, Object> initialValues,
		final Map<String, IType> types) {
		return null;
	}

	@Override
	public void openUserControlPanel(final IScope scope, final UserPanelStatement panel) {}

	@Override
	public void closeDialogs() {}

	@Override
	public IAgent getHighlightedAgent() {
		return null;
	}

	@Override
	public void setHighlightedAgent(final IAgent a) {}

	@Override
	public void setStatus(final String error, final int code) {}

	@Override
	public void run(final Runnable block) {
		block.run();
	}

	@Override
	public void asyncRun(final Runnable block) {
		block.run();
	}

	@Override
	public void raise(final Throwable ex) {
		Logger.getAnonymousLogger().fine("Error: " + ex.getMessage());
		// System.out.println("Error: " + ex.getMessage());
	}

	@Override
	public IGamaView showView(final String viewId, final String name, final int code) {
		return null;
	}

	@Override
	public void tell(final String message) {
		Logger.getAnonymousLogger().finest("Message: " + message);
		// System.out.println("Message: " + message);
	}

	@Override
	public void error(final String error) {
		// System.out.println("Error: " + error);
		Logger.getAnonymousLogger().fine("Error: " + error);

	}

	@Override
	public void showParameterView(final IExperimentSpecies exp) {}

	@Override
	public void debugConsole(final int cycle, final String s) {
		Logger.getAnonymousLogger().finer("Debug (step " + cycle + "): " + s);
		// System.out.println("Debug (step " + cycle + "): " + s);
	}

	@Override
	public void informConsole(final String s) {
		Logger.getAnonymousLogger().finer("Information: " + s);
		// System.out.println("Information: " + s);
	}

	@Override
	public void updateViewOf(final IDisplayOutput output) {}

	@Override
	public void debug(final String string) {
		Logger.getAnonymousLogger().finest("Debug: " + string);
	}

	@Override
	public void warn(final String string) {
		Logger.getAnonymousLogger().fine("Warning: " + string);
		// System.out.println("Warning: " + string);
	}

	@Override
	public void runtimeError(final GamaRuntimeException g) {
		Logger.getAnonymousLogger().fine("Runtime error: " + g.getMessage());
		// System.out.println("Runtime error: " + g.getMessage());
	}

	@Override
	public IEditorFactory getEditorFactory() {
		return null;
	}

	@Override
	public boolean confirmClose(final IExperimentSpecies experiment) {
		return true;
	}

	@Override
	public void prepareForExperiment(final IExperimentSpecies exp) {}

	@Override
	public void showConsoleView() {}

	@Override
	public void setWorkbenchWindowTitle(final String string) {}

	@Override
	public void closeViewOf(final IDisplayOutput out) {}

	@Override
	public IGamaView hideView(final String viewId) {
		return null;
	}

	@Override
	public boolean isModelingPerspective() {
		return true;
	}

	@Override
	public boolean openModelingPerspective() {
		return false;
	}

	@Override
	public boolean isSimulationPerspective() {
		return true;
	}

	@Override
	public void togglePerspective() {}

	@Override
	public boolean openSimulationPerspective() {
		return true;
	}

	static Map<String, Class> displayClasses = null;

	@Override
	public IDisplaySurface getDisplaySurfaceFor(final IScope scope, final String keyword,
		final LayeredDisplayOutput layerDisplayOutput, final double w, final double h, final Object ... args) {
		if ( displayClasses == null ) {
			displayClasses = new HashMap();
			IConfigurationElement[] config =
				Platform.getExtensionRegistry().getConfigurationElementsFor("gama.display");
			for ( IConfigurationElement e : config ) {
				final String pluginKeyword = e.getAttribute("keyword");
				final String pluginClass = e.getAttribute("class");
				// final Class<IDisplaySurface> displayClass = .
				final String pluginName = e.getContributor().getName();
				// System.out.println("displays " + pluginKeyword + " " + pluginName);
				ClassLoader cl = GamaClassLoader.getInstance().addBundle(Platform.getBundle(pluginName));
				try {
					displayClasses.put(pluginKeyword, cl.loadClass(pluginClass));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
		// keyword = "image";
		Class<IDisplaySurface> clazz = displayClasses.get("image");
		if ( clazz == null ) { return new NullDisplaySurface(); /*
																 * throw GamaRuntimeException.error("Display " + keyword
																 * + " is not defined anywhere.");
																 */}
		try {
			IDisplaySurface surface = clazz.newInstance();
			Logger.getAnonymousLogger().fine(
				"Instantiating " + clazz.getSimpleName() + " to produce a " + keyword + " display");
			// debug("Instantiating " + clazz.getSimpleName() + " to produce a " + keyword + " display");
			surface.initialize(scope, w, h, layerDisplayOutput);
			return surface;
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}

		return null;
	}

	@Override
	public void editModel(final Object eObject) {}

	@Override
	public void updateParameterView(final IExperimentSpecies exp) {}

	//
	// @Override
	// public void cycleDisplayViews(final Set<String> names) {}

	@Override
	public void setSelectedAgent(final IAgent a) {}

	@Override
	public void cleanAfterExperiment(final IExperimentSpecies exp) {}

	@Override
	public void prepareForSimulation(final SimulationAgent agent) {}

	@Override
	public void cleanAfterSimulation() {}

	@Override
	public void waitForViewsToBeInitialized() {}

	@Override
	public void debug(final Exception e) {
		e.printStackTrace();
	}

	@Override
	public void runModel(final Object object, final String exp) throws CoreException {}

	/**
	 * Method getFirstDisplaySurface()
	 * @see msi.gama.common.interfaces.IGui#getFirstDisplaySurface()
	 */
	@Override
	public IDisplaySurface getFirstDisplaySurface() {
		return null;
	}

	/**
	 * Method updateSpeedDisplay()
	 * @see msi.gama.common.interfaces.IGui#updateSpeedDisplay(java.lang.Double)
	 */
	@Override
	public void updateSpeedDisplay(final Double d, final boolean notify) {}
}
