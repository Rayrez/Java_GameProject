package entity.mouvable.collectible;

public class Diamond extends Collectible {

	public Diamond() {
		super('V', "images/sprites/diamond.gif");
		this.submittedToGravity = true;
		this.name = "Diamond";
	}
}
