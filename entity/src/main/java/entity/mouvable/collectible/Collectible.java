package entity.mouvable.collectible;

import entity.Capacities;
import entity.mouvable.Mouvable;

public abstract class Collectible extends Mouvable {
	
	protected String name;
	
	public Collectible(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.COLLECTIBLE;
	}
	
	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
	
	public String getName() {
		return this.name;
	}
}
