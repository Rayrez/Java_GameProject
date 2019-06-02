package entity.movable;

/**
 * The class rock
 *
 * @author Pierre GARRIDO
 */
public class Rock extends Movable {

	/**
	 * Make the corresponding with the symbol "R" and the sprite of rock.
	 */
	public Rock() {
		super('R', "images/sprites/rock.gif");
		this.submittedToGravity = true;
	}

}