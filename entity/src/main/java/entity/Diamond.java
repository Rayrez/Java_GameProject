package entity;

public class Diamond extends Mouvable {

	public Diamond(int xP, int yP) {
		super('V', "images/sprites/diamond.gif", xP, yP);
		this.submittedToGravity = true;
	}

}
