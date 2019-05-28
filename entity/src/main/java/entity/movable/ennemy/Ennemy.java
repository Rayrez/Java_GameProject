package entity.movable.ennemy;

import entity.movable.Movable;

public class Ennemy extends Movable {

	public Ennemy(char symbol, String fileName) {
		super(symbol, fileName);
		this.submittedToGravity = false;
	}

	public void killSb(Movable victim) {
		victim.kill();
	}
}
