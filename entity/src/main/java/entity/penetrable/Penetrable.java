package entity.penetrable;

import entity.Capacities;
import entity.Entity;

/**
 * The abstract class Penetrable.
 *
 * @author Pierre GARRIDO
 */
public abstract class Penetrable extends Entity {

	/**
	 * Set the capacity Penetrable.
	 *
	 * @param symbol
	 * 			The symbol.
	 * @param fileName
	 * 			Name of a sprite file.
	 */
	public Penetrable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.PENETRABLE;
		
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
