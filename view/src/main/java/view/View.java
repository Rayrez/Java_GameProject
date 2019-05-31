package view;

import javax.swing.*;
import contract.*;

/**
 * The Class View.
 *
 * @author Bastien Aelters, Benjamin Brifault
 */
public class View extends JFrame implements IView {

	/**
	 * Variable declarations.
	 */
	private static final long serialVersionUID = 3729391891433730765L;
	private final IModel model;
	private Components components;
	private IController controller;

	public View(IModel modelP) {
		this.model = modelP;
		this.components = new Components(modelP);
		this.setContentPane(this.components);
		this.setTitle("Boulder Dash");
		this.setSize(407, 483);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void setController(final IController controllerP) {
		this.controller = controllerP;
		this.model.getObservable().addObserver(this.components);
		this.addKeyListener(new DashKeyListener(this.controller));
		this.setVisible(true);
	}

}
