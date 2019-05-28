package contract;

import java.util.Observable;

import entity.Entity;
import contract.Order;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the map.
	 *
	 * @return map
	 */
	Entity[][] getMap();
	
	/**
	 * Permit to give a model order
	 *
	 * @param order
	 *           the order
	 */
	void giveOrder(Order order);
	
	/**
     * Gets the score.
     *
     * @return the score
     */
	int getScore();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
