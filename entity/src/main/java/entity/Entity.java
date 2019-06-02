package entity;

/**
 * The Class Entity.
 *
 * @author Pierre GARRIDO
 */
public abstract class Entity {

	/**
	 * Variable declarations.
	 */
	protected Sprite baseSprite;
	private boolean set = false;
	protected int x;
	protected int y;
	protected Capacities capacity;

	/**
	 * Instantiates a new Entity.
	 *
	 * @param symbol
	 * 			The symbol.
	 * @param fileName
	 * 			Name of a sprite file.
	 */
	public Entity(char symbol, String fileName) {
		this.baseSprite = new Sprite(symbol, fileName);
	}

	/**
	 * Gets the sprite.
	 *
	 * @return the sprite.
	 */
	public Sprite getBaseSprite() {
		return this.baseSprite;
	}

	/**
	 * Gets the X.
	 *
	 * @return the X.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets the Y.
	 *
	 * @return the Y.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Set the position (X and Y) to xP and Yp.
	 *
	 * @param xP
	 * 			the X position.
	 * @param yP
	 * 			the Y position.
	 */
	public void setXY(int xP, int yP) {
		if(!set) {
			if(xP < 0 || yP < 0)
			{
				throw new IllegalArgumentException("X and Y should be greather than 0");
			}
			else
			{
				this.x = xP;
				this.y = yP;
				this.set = true;
			}
		}
		else
			throw new RuntimeException("This entity is already set !");
		
	}

	/**
	 * Gets the capacity.
	 *
	 * @return nothing.
	 */
	public Capacities getCapacity() {
		return null;
	}
}
