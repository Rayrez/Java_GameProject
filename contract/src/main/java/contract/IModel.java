package contract;

import java.util.Observable;

import entity.Entity;

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
	void giveOrder(ControllerOrder order);
	
	/**
     * Gets the score.
     *
     * @return the score
     */
	int getScore();

	/**
    * Gets the number of remaining diamonds.
    *
    * @return the number of remaining diamond
    */
	public int getDiamonds_remaining();
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
