package entity.mouvable;

import entity.Capacities;
import entity.Entity;

public abstract class Mouvable extends Entity {
	
	protected boolean submittedToGravity;
	protected boolean alive = true;
	
	public Mouvable(char symbol, String fileName) {
		super(symbol, fileName);
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
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void kill() {
		this.alive = false;
	}
}