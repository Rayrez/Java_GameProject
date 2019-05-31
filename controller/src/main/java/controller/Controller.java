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
     * Give a key
     *
     * @param character
     *            the given character by the view
     */
	@Override
	public void giveKey(char character) {
		
	}

}
