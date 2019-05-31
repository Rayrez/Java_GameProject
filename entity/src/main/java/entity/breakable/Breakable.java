package entity.breakable;

import entity.Capacities;
import entity.Entity;

/**
 * The abstract class Breakable.
 *
 * @Author PIERRE GARRIDO
 */
public abstract class Breakable extends Entity {

	/**
	 * Set the capacity Breakable.
	 *
	 * @param symbol
	 * @param fileName
	 */
	public Breakable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.BREAKABLE;
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
