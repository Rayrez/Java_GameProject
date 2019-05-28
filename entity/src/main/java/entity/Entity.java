package entity;

/**
 * The Class Entity.
 *
 * @author Pierre GARRIDO
 */
public abstract class Entity {
	
	protected Sprite baseSprite;
	private boolean set = false;
	protected int x;
	protected int y;
	protected Capacities capacity;
	
	public Entity(char symbol, String fileName) {
		this.baseSprite = new Sprite(symbol, fileName);
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
	
	public void setXY(int xP, int yP) {
		if(!set) {
			if(xP < 0 || yP < 0)
			{
				throw new RuntimeException("X and Y should be greather than 0");
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
	
	public Capacities getCapacity() {
		return null;
	}
}
