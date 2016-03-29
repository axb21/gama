/*********************************************************************************************
 *
 *
 * 'UserControlView.java', in plugin 'msi.gama.application', is part of the source code of the
 * GAMA modeling and simulation platform.
 * (c) 2007-2014 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://code.google.com/p/gama-platform/ for license information and developers contact.
 *
 *
 **********************************************************************************************/
package msi.gama.gui.views;

import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolItem;
import msi.gama.common.interfaces.EditorListener;
import msi.gama.gui.parameters.EditorFactory;
import msi.gama.gui.swt.GamaIcons;
import msi.gama.gui.swt.IGamaColors;
import msi.gama.gui.swt.IGamaIcons;
import msi.gama.gui.swt.controls.FlatButton;
import msi.gama.gui.swt.controls.GamaToolbar2;
import msi.gama.runtime.GAMA;
import msi.gama.runtime.IScope;
import msi.gama.runtime.exceptions.GamaRuntimeException;
import msi.gaml.architecture.user.UserInputStatement;
import msi.gaml.statements.IStatement;
import msi.gaml.statements.UserCommandStatement;

public class UserControlView extends GamaViewPart {

	public static String ID = "msi.gama.views.userControlView";

	private IScope scope;
	private List<IStatement> userCommands;
	private String title;
	private Composite body;
	ToolItem inspectItem, continueItem;

	public void initFor(final IScope scope, final List<IStatement> userCommands, final String title) {
		this.scope = scope;
		this.userCommands = userCommands;
		this.title = title;
		if ( body != null && !body.isDisposed() ) {
			body.dispose();
			body = null;
		}

		ownCreatePartControl(parent);
		parent.layout();
	}

	private void deactivate(final Composite parent) {
		for ( final Control c : parent.getChildren() ) {
			if ( c instanceof Composite ) {
				deactivate((Composite) c);
			} else {
				c.setEnabled(false);
			}
		}
	}

	@Override
	public void ownCreatePartControl(final Composite parent) {
		parent.setBackground(IGamaColors.WHITE.color());
		if ( scope == null ) { return; }
		inspectItem.setEnabled(true);
		continueItem.setEnabled(true);
		setPartName(title);
		parent.setLayout(new FillLayout());
		parent.setBackground(IGamaColors.WHITE.color());
		toolbar.status((Image) null,
			"User control, agent " + scope.getAgentScope().getName() + ", cycle " + scope.getClock().getCycle(),
			IGamaColors.NEUTRAL, SWT.LEFT);
		body = new Composite(parent, SWT.None);
		GridLayout layout = new GridLayout(3, false);
		body.setLayout(layout);
		body.setBackground(IGamaColors.WHITE.color());
		for ( final IStatement c : userCommands ) {
			if ( c instanceof UserCommandStatement ) {
				final Composite commandComposite = new Composite(body, SWT.BORDER);
				final GridData data = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
				commandComposite.setLayoutData(data);
				layout = new GridLayout(3, false);
				commandComposite.setLayout(layout);
				commandComposite.setBackground(IGamaColors.WHITE.color());
				final List<UserInputStatement> inputs = ((UserCommandStatement) c).getInputs();
				final int nbLines = inputs.size() > 1 ? inputs.size() : 1;
				final int nbCol = inputs.size() > 0 ? 1 : 3;
				final FlatButton b = FlatButton.button(commandComposite, IGamaColors.BLUE, c.getName(),
					GamaIcons.create("small.run").image());
				b.setEnabled(((UserCommandStatement) c).isEnabled(scope));
				final GridData gd = new GridData(SWT.LEFT, SWT.CENTER, true, true, nbCol, nbLines);
				b.setLayoutData(gd);
				b.addSelectionListener(new SelectionAdapter() {

					@Override
					public void widgetSelected(final SelectionEvent e) {
						c.executeOn(scope);
						GAMA.getExperiment().refreshAllOutputs();;
					}

				});
				for ( final UserInputStatement i : inputs ) {
					scope.addVarWithValue(i.getTempVarName(), i.value(scope));
					EditorFactory.create(scope, commandComposite, i, new EditorListener() {

						@Override
						public void valueModified(final Object newValue) throws GamaRuntimeException {
							i.setValue(scope, newValue);
							i.executeOn(scope);
						}
					}, false);
				}

			}
		}

	}

	@Override
	protected GamaUIJob createUpdateJob() {
		return new GamaUIJob() {

			@Override
			protected UpdatePriority jobPriority() {
				return UpdatePriority.HIGH;
			}

			@Override
			public IStatus runInUIThread(final IProgressMonitor monitor) {
				initFor(scope, userCommands, title);
				return Status.OK_STATUS;
			}
		};
	}

	/**
	 * Method createToolItem()
	 * @see msi.gama.gui.views.IToolbarDecoratedView#createToolItem(int, msi.gama.gui.swt.controls.GamaToolbar2)
	 */
	@Override
	public void createToolItems(final GamaToolbar2 tb) {
		super.createToolItems(tb);

		inspectItem = tb.button(IGamaIcons.PANEL_INSPECT.getCode(), "Inspect", "Inspect", new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				scope.getGui().setSelectedAgent(scope.getAgentScope());
			}

		}, SWT.RIGHT);
		inspectItem.setEnabled(false);
		continueItem = tb.button(IGamaIcons.PANEL_CONTINUE.getCode(), "Continue", "Continue", new SelectionListener() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				GAMA.getFrontmostController().getScheduler().setUserHold(false);
				deactivate(parent);
				scope.getGui().hideView(ID);
			}

			@Override
			public void widgetDefaultSelected(final SelectionEvent e) {
				widgetSelected(e);
			}

		}, SWT.RIGHT);
		continueItem.setEnabled(false);

	}

}
