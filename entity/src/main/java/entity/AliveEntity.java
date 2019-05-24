package entity;

public class AliveEntity extends Entity {

	private boolean alive = true;
	
	public AliveEntity(char symbol, String fileName) {
		super(symbol, fileName);
	}
	
	public void kill() {
		this.alive = false;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void setX(int xP) {
		this.x = xP;
	}
	
	public void setY(int yP) {
		this.x = yP;
	}
}
