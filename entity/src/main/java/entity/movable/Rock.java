package entity.movable;

public class Rock extends Movable {

	public Rock() {
		super('R', "../images/sprites/rock.gif");
		this.submittedToGravity = true;
	}

}