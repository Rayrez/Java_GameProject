package entity;

public abstract class Unbreakable extends Entity {

	public Unbreakable(char symbol, String fileName, int xP, int yP) {
		super(symbol, fileName, xP, yP);
		this.capacity = Capacities.UNBREAKABLE;
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
