package entity;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	
	private Sprite baseSprite;
	protected int x;
	protected int y;
	
	public Entity(char symbol, String fileName) {
		this.baseSprite = new Sprite(symbol, fileName);
		this.x = 0;
		this.y = 0;
	}
	
	public Sprite getBaseSprite() {
		return this.baseSprite;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public Capacities getCapacity() {
		return null;
	}
}
