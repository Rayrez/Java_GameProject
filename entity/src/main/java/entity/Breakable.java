package entity;

public abstract class Breakable extends Entity {

	public Breakable(char symbol, String fileName, int xP, int yP) {
		super(symbol, fileName, xP, yP);
		this.capacity = Capacities.BREAKABLE;
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
