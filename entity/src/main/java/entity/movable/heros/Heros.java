package entity.movable.heros;

import entity.Direction;
import entity.Sprite;
import entity.movable.Mouvable;

public class Heros extends Mouvable {
	
	private Sprite left;
	private Sprite right;
	private Sprite usedSprite;
	private Direction dir;

	public Heros() {
		super('H', "../images/sprites/face.gif");
		this.right = new Sprite('J', "../images/sprites/right.gif");
		this.left = new Sprite('L', "../images/sprites/left.gif");
		this.setUsedSprite(this.getBaseSprite());
		this.dir = Direction.FACE;
	}

	public Direction getDir() {
		return this.dir;
	}

	public void setDir(Direction dirP) {
		this.dir = dirP;
		
		if(dirP == Direction.FACE)
			this.setUsedSprite(this.getBaseSprite());
		else if(dirP == Direction.LEFT)
			this.setUsedSprite(this.left);
		else if(dirP == Direction.RIGHT)
			this.setUsedSprite(this.right);
		else
			throw new RuntimeException("Invalid direction");
	}

	public Sprite getUsedSprite() {
		return this.usedSprite;
	}

	public void setUsedSprite(Sprite usedSpriteP) {
		this.usedSprite = usedSpriteP;
	}
}
