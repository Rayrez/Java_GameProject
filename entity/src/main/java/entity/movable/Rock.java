package entity.movable;

public class Rock extends Mouvable {

	public Rock() {
		super('R', "../images/sprites/rock.gif");
		this.submittedToGravity = true;
	}

}