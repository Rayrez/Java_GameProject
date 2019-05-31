package entity.penetrable;

/**
 * The class Exit
 *
 * @author Pierre GARRIDO
 */
public class Exit extends Penetrable {

	/**
	 * Variable declarations
	 */
	private boolean visible;

	/**
	 * The corresponding between the symbol "E" and the sprite of the exit.
	 */
	public Exit() {
		super('E', "images/sprites/exit.gif");
	}

	/**
	 * Show the exit
	 *
	 * @return The exit display
	 */
	public boolean isVisible() {
		return this.visible;
	}

	/**
	 * Set if the exit is visible or not
	 *
	 * @param visibleP
	 */
	public void setVisible(boolean visibleP) {
		this.visible = visibleP;
	}
	
	

}
