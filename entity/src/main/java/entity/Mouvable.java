package entity;

public abstract class Mouvable extends Entity {
	
	protected boolean submittedToGravity;
	
	public Mouvable(char symbol, String fileName, int xP, int yP) {
		super(symbol, fileName, xP, yP);
		this.capacity = Capacities.MOVABLE;
	}
	
	public void setX(int xP) {
		this.x = xP;
	}
	
	public void setY(int yP) {
		this.x = yP;
	}
	
	public boolean isSubmittedToGravity() {
		return this.submittedToGravity;
	}
}