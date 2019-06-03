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
	}

	/**
     * Control.
     */
	public void control() {

	}

	@Override
	public void giveKey(char character) {

	      if (character == 'Z'){
	          this.model.giveOrder(ControllerOrder.MoveUp);
	      }
	      else if (character == 'S'){
	          this.model.giveOrder(ControllerOrder.MoveDown);
	      }
	      else if (character == 'Q'){
	          this.model.giveOrder(ControllerOrder.MoveLeft);
	      }
	      else if (character == 'D'){
	          this.model.giveOrder(ControllerOrder.MoveRight);
	      }
	      else if (character == 'P'){
	          this.model.giveOrder(ControllerOrder.Pause);
	      }
	      else if (character == 'R'){
	          this.model.giveOrder(ControllerOrder.Reset);
	      }
	}

}
