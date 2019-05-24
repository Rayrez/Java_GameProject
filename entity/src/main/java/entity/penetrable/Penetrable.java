package entity.penetrable;

import entity.Capacities;
import entity.Entity;

public abstract class Penetrable extends Entity {

	public Penetrable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.PENETRABLE;
		
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
