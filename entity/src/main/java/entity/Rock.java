package entity;

public class Rock extends Mouvable {

	public Rock(int xP, int yP) {
		super('R', "images/sprites/rock.gif", xP, yP);
		this.submittedToGravity = true;
	}

}