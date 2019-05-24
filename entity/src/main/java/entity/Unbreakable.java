package entity;

public abstract class Unbreakable extends Entity {
	
	private Capacities capacity;

	public Unbreakable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.UNBREAKABLE;
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
