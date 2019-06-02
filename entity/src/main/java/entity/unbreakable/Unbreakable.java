package entity.unbreakable;

import entity.Capacities;
import entity.Entity;

/**
 * The abstract class Unbreakable.
 *
 * @author Pierre GARRIDO
 */
public abstract class Unbreakable extends Entity {

	/**
	 * Set the capacity Unbreakable.
	 *
	 * @param symbol
	 * 			The symbol.
	 * @param fileName
	 * 			Name of a sprite file.
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