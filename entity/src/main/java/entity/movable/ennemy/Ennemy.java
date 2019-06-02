package entity.movable.ennemy;

import entity.movable.Movable;

/**
 * The class Enemy.
 *
 * @author Pierre GARRIDO
 */
public class Ennemy extends Movable {

	/**
	 * Set the enemy not submitted to the gravity.
	 *
	 * @param symbol;
	 * @param fileName;
	 */
	public Ennemy(char symbol, String fileName) {
		super(symbol, fileName);
		this.submittedToGravity = false;
	}

	/**
	 * Kill the victim if the victim touch the ennemy.
	 *
	 * @param victim;
	 */
	public void killSb(Movable victim) {
		victim.kill();
	}
}
