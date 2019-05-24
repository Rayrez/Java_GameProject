package entity.mouvable;

public class Rock extends Mouvable {

	public Rock() {
		super('R', "images/sprites/rock.gif");
		this.submittedToGravity = true;
	}

}