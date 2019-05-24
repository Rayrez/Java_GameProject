package entity;

/**
 * The Class Entity.
 *
 * @author Pierre GARRIDO
 */
public abstract class Entity {
	
	private Sprite baseSprite;
	protected int x;
	protected int y;
	protected Capacities capacity;
	
	public Entity(char symbol, String fileName, int xP, int yP) {
		this.baseSprite = new Sprite(symbol, fileName);
		this.x = xP;
		this.y = yP;
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
