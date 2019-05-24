package entity;

public abstract class Breakable extends Entity {
	
	private Capacities capacity;

	public Breakable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.BREAKABLE;
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
