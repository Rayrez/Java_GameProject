package entity.movable.collectible;

import entity.Capacities;
import entity.movable.Movable;

public abstract class Collectible extends Movable {
	
	protected String name;
	
	public Collectible(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.COLLECTIBLE;
	}
	
	public String getName() {
		return this.name;
	}
}
