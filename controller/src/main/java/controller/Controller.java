package controller;

import contract.*;
import model.Model;
import view.View;

/**
 * The Class Controller.
 *
 * @author Mattias HUROT
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
		this.view.setController(this);
		this.control();
	}

	/**
     * Control.
     */
	private void control() {
		while(!model.hasWon());
		model = new Model(2);
		while(!model.hasWon());
		model = new Model(3);
		while(!model.hasWon());
		model = new Model(4);
		while(!model.hasWon());
		model = new Model(5);
	}

	@Override
	public void giveKey(char caracter) {

	      if (caracter == 'Z'){
	          this.model.giveOrder(ControllerOrder.MoveUp);
	      }
	      else if (caracter == 'S'){
	          this.model.giveOrder(ControllerOrder.MoveDown);
	      }
	      else if (caracter == 'Q'){
	          this.model.giveOrder(ControllerOrder.MoveLeft);
	      }
	      else if (caracter == 'D'){
	          this.model.giveOrder(ControllerOrder.MoveRight);
	      }
	      else if (caracter == 'P'){
	          this.model.giveOrder(ControllerOrder.Pause);
	      }
	      else if (caracter == 'R'){
	          this.model.giveOrder(ControllerOrder.Reset);
	      }
	}

}
