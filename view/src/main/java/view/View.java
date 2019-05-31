package view;

import javax.swing.*;
import contract.*;

/**
 * The Class View.
 *
 * @author Bastien Aelters, Benjamin Brifault
 */
public class View extends JFrame implements IView, Runnable {

	/**
	 * Variable declarations.
	 */
	private static final long serialVersionUID = 3729391891433730765L;
	private final IModel model;
	private Components components;

	public View(IModel modelP) {
		this.model = modelP;
		this.components = new Components(modelP);
		this.setContentPane(this.components);
		this.setTitle("Boulder Dash");
		this.setSize(407, 483);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.model.getObservable().addObserver(this.components);
		this.setVisible(true);
	}

	public void printMessage(final String message) {

	}

	public void run() {

	}

	public void setController(final IController controller) {
	}

}
