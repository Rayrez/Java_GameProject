package entity;

public class Collectible extends Entity {

	private Capacities capicity;
	
	public Collectible(char symbol, String fileName) {
		super(symbol, fileName);
		this.capicity = Capacities.COLLECTIBLE;
	}
	
	@Override
	public Capacities getCapacity() {
		return this.capicity;
	}
}
