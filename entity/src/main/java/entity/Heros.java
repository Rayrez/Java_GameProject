package entity;

public class Heros extends Mouvable implements Living {
	
	private Sprite left;
	private Sprite right;
	private Sprite usedSprite;
	private boolean alive;
	private Direction dir;

	public Heros(int xP, int yP) {
		super('H', "images/sprites/face.gif", xP, yP);
		this.right = new Sprite('J', "images/sprites/right.gif");
		this.left = new Sprite('L', "images/sprites/left.gif");
		this.usedSprite = this.getBaseSprite();
	}

	@Override
	public boolean isAlive() {
		return this.alive;
	}

	@Override
	public void kill() {
		this.alive = false;
	}

	public Direction getDir() {
		return this.dir;
	}

	public void setDir(Direction dirP) {
		this.dir = dirP;
		
		if(dirP == Direction.FACE)
			this.usedSprite = this.getBaseSprite();
		else if(dirP == Direction.LEFT)
			this.usedSprite = this.left;
		else if(dirP == Direction.RIGHT)
			this.usedSprite = this.right;
		else
			throw new RuntimeException("Invalid direction");
	}
}
