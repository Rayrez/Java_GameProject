package entity;

public class Octopus extends Mouvable implements Killer {

	private boolean alive = true;
	
	public Octopus(int xP, int yP) {
		super('K', "images/sprites/octopus.gif", xP, yP);
	}

	@Override
	public boolean isAlive() {
		return this.alive;
	}

	@Override
	public void kill() {
		this.alive = false;
	}

	@Override
	public void killSb(Living victim) {
		victim.kill();
	}

}
