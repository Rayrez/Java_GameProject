package entity.penetrable;

public class Exit extends Penetrable {
	
	private boolean visible;

	public Exit() {
		super('E', "../images/sprites/exit.gif");
	}

	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visibleP) {
		this.visible = visibleP;
	}
	
	

}
