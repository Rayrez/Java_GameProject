package entity.movable;

import entity.Capacities;
import entity.Entity;

/**
 * The abstract class Movable.
 *
 * @author Pierre GARRIDO
 */
public abstract class Movable extends Entity {

	/**
	 * Variable declarations
	 */
	protected boolean submittedToGravity;
	protected boolean alive = true;
	private boolean mortal = false;

	/**
	 * Set the capacity Breakable.
	 *
	 * @param symbol
	 * @param fileName
	 */
	public Movable(char symbol, String fileName) {
		super(symbol, fileName);
		this.capacity = Capacities.MOVABLE;
	}

	/**
	 * Set X.
	 *
	 * @param xP
	 * 			Variable who contains X value
	 */
	public void setX(int xP) {
		if(xP < 0)
		{
			throw new IllegalArgumentException("X and Y should be greather than 0");
		}
		else
		{
			this.x = xP;
		}
	}

	/**
	 * Set Y.
	 *
	 * @param yP
	 * 			Variable who contains Y value
	 */
	public void setY(int yP) {
		if(yP < 0)
		{
			throw new IllegalArgumentException("X and Y should be greather than 0");
		}
		else
		{
			this.y = yP;
		}
	}

	/**
	 * Return if the entity is submitted to the "gravity".
	 *
	 * @return The boolean submitted to gravity.
	 */
	public boolean isSubmittedToGravity() {
		return this.submittedToGravity;
	}

	/**
	 * Return if the entity is alive or not.
	 *
	 * @return the boolean alive
	 */
	public boolean isAlive() {
		return this.alive;
	}

	/**
	 * Set the boolean alive to false when an entity is killed.
	 */
	public void kill() {
		this.alive = false;
	}
	
	@Override
	public Capacities getCapacity() {
		return this.capacity;
	}

	/**
	 * Set an entity to mortal : she can be killed.
	 */
	public void becomeMortal() {
		this.mortal = true;
	}

	/**
	 * Return if the entity is mortal or not.
	 *
	 * @return the boolean mortal
	 */
	public boolean isMortal() {
		return this.mortal;
	}
}