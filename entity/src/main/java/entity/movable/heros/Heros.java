package entity.movable.heros;

import entity.Direction;
import entity.Sprite;
import entity.movable.Movable;

/**
 * The class Heros
 *
 * @author Pierre GARRIDO
 */
public class Heros extends Movable {

	/**
	 * Variable declarations
	 */
	private Sprite left;
	private Sprite right;
	private Sprite face;
	private Direction dir;

	/**
	 * Make the corresponding with the symbols and the sprite of the heros associated.
	 */
	public Heros() {
		super('H', "images/sprites/face.gif");
		this.right = new Sprite('J', "images/sprites/right.gif");
		this.left = new Sprite('L', "images/sprites/left.gif");
		this.face = this.getBaseSprite();
		this.dir = Direction.FACE;
	}

	/**
	 * Get the direction where the hero go.
	 *
	 * @return The direction
	 */
	public Direction getDir() {
		return this.dir;
	}

	/**
	 * Set the good sprite to each direction
	 * @param dirP
	 */
	public void setDir(Direction dirP) {
		this.dir = dirP;
		
		if(dirP == Direction.FACE)
			this.setBaseSprite(this.face);
		else if(dirP == Direction.LEFT)
			this.setBaseSprite(this.left);
		else if(dirP == Direction.RIGHT)
			this.setBaseSprite(this.right);
		else
			throw new RuntimeException("Invalid direction");
	}

	/**
	 * Set the sprite of the hero
	 *
	 * @param sP
	 */
	private void setBaseSprite(Sprite sP)
	{
		this.baseSprite = sP;
	}
}
