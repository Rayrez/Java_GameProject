package entity.movable.collectible;

import entity.Capacities;
import entity.movable.Mouvable;

public abstract class Collectible extends Mouvable {
	
	protected String name;
	
	public Collectible(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.COLLECTIBLE;
	}
	
	public String getName() {
		return this.name;
	}
}
