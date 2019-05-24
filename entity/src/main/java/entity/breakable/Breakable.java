package entity.breakable;

import entity.Capacities;
import entity.Entity;

public abstract class Breakable extends Entity {

	public Breakable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.BREAKABLE;
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
