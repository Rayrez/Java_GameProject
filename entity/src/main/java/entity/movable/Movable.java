package entity.movable;

import entity.Capacities;
import entity.Entity;

public abstract class Movable extends Entity {
	
	protected boolean submittedToGravity;
	protected boolean alive = true;
	
	public Movable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.MOVABLE;
	}
	
	public void setX(int xP) {
		if(xP < 0)
		{
			throw new RuntimeException("X and Y should be greather than 0");
		}
		else
		{
			this.x = xP;
		}
	}
	
	public void setY(int yP) {
		if(yP < 0)
		{
			throw new RuntimeException("X and Y should be greather than 0");
		}
		else
		{
			this.y = yP;
		}
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
	
	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}
}