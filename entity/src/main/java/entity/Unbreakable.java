package entity;

public abstract class Unbreakable extends Entity {
	
	private Breakability capacity;

	public Unbreakable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Breakability.UNBREAKABLE;
	}

	public Breakability getCapacity() {
		return this.capacity;
	}
}
