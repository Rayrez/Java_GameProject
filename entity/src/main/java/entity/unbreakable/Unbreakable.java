package entity.unbreakable;

import entity.Capacities;
import entity.Entity;

/**
 * The abstract class Unbreakable
 *
 * @author Pierre GARRIDO
 */
public abstract class Unbreakable extends Entity {

	/**
	 * Set the capacity Unbreakable
	 *
	 * @param symbol
	 * @param fileName
	 */
	public Unbreakable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.UNBREAKABLE;
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
