package controller;

import contract.*;
import model.Model;
import view.View;

/**
 * The Class Controller.
 *
 * @author Mattias Huros
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		model = new Model(1);
		view = new View(model);
	}

	/**
     * Control.
     */
	public void control() {

	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	public void orderPerform(final ControllerOrder controllerOrder) {

	}

}
