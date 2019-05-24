package entity.unbreakable;

import entity.Capacities;
import entity.Entity;

public abstract class Unbreakable extends Entity {

	public Unbreakable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.UNBREAKABLE;
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
