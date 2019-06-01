package entity.movable.collectible;

/**
 * The class diamond
 *
 * @author Pierre GARRIDO
 */
public class Diamond extends Collectible {

	/**
	 * Make the corresponding with the symbol "V" and the sprite of diamond
	 *
	 * Submit the diamond to gravitu
	 *
	 * Set the name of the diamond to diamond
	 */
	public Diamond() {
		super('V', "images/sprites/diamond.gif");
		this.submittedToGravity = true;
		this.name = "Diamond";
	}
}
