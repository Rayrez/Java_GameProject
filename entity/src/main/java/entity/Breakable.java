package entity;

public abstract class Breakable extends Entity {
	
	private Breakability capacity;

	public Breakable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Breakability.BREAKABLE;
	}
}
