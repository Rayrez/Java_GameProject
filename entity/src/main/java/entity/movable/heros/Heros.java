package entity.movable.heros;

import entity.Direction;
import entity.Sprite;
import entity.movable.Movable;

public class Heros extends Movable {
	
	private Sprite left;
	private Sprite right;
	private Sprite face;
	private Direction dir;

	public Heros() {
		super('H', "../images/sprites/face.gif");
		this.right = new Sprite('J', "../images/sprites/right.gif");
		this.left = new Sprite('L', "../images/sprites/left.gif");
		this.face = this.getBaseSprite();
		this.dir = Direction.FACE;
	}

	public Direction getDir() {
		return this.dir;
	}

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
	
	private void setBaseSprite(Sprite sP)
	{
		this.baseSprite = sP;
	}
}
