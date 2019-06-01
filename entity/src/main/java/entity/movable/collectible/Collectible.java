package entity.movable.collectible;

import entity.Capacities;
import entity.movable.Movable;

/**
 * The abstract class Collectible.
 *
 * @author Pierre GARRIDO
 */
public abstract class Collectible extends Movable {

	/**
	 * Variable declarations.
	 */
	protected String name;

	/**
	 * Set the capacity collectible
	 *
	 * @param symbol
	 * @param fileName
	 */
	public Collectible(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.COLLECTIBLE;
	}

	/**
	 * Get the name of the collectible
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
}
