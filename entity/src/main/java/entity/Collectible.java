package entity;

public abstract class Collectible extends Entity {
	
	public Collectible(char symbol, String fileName, int xP, int yP) {
		super(symbol, fileName, xP, yP);
		this.capacity = Capacities.COLLECTIBLE;
	}
	
	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
