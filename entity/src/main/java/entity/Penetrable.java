package entity;

public class Penetrable extends Entity {

	private Capacities capacity;

	public Penetrable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.PENETRABLE;
		
	}

	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}
