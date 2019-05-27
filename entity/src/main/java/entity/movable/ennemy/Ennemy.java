package entity.movable.ennemy;

import entity.movable.Mouvable;

public class Ennemy extends Mouvable {

	public Ennemy(char symbol, String fileName) {
		super(symbol, fileName);
	}

	public void killSb(Mouvable victim) {
		victim.kill();
	}
}
