package entity;

public abstract class Penetrable extends Entity {

	public Penetrable(char symbol, String fileName, int xP, int yP) {
		super(symbol, fileName, xP, yP);
		this.capacity = Capacities.PENETRABLE;
		
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
