package view;

import contract.IController;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Class KeyListener.
 *
 * @author Bastien AELTERS, Benjamin BRIFAULT
 */
public class DashKeyListener implements KeyListener {


    /**
	 * Variable declarations.
	 */
	private static final long serialVersionUID = 6957355209405412190L;
	private IController controler;

	/**
	 * Connexion with controller class via IController class.
	 *
	 * @param controlerP
	 *			The controller.
	 */
	public DashKeyListener(IController controlerP) {
		this.controler = controlerP;
    }

	@Override
    public void keyPressed(KeyEvent arg0){
    }

	@Override
	public void keyReleased(KeyEvent e) {
		
		 int keycode = e.getKeyCode();

	     if (keycode == KeyEvent.VK_UP){
	         this.controler.giveKey('Z');
	     }

	     if (keycode == KeyEvent.VK_DOWN){
	        this.controler.giveKey('S');
	     }
	     
	     if (keycode == KeyEvent.VK_LEFT){
	       	this.controler.giveKey('Q');
	     }

	     if (keycode == KeyEvent.VK_RIGHT){
	        this.controler.giveKey('D');
	     }

		if (keycode == KeyEvent.VK_P){
			this.controler.giveKey('P');
		}

		if (keycode == KeyEvent.VK_R){
			this.controler.giveKey('R');
		}

		if (keycode == KeyEvent.VK_P){
			this.controler.giveKey('P');
		}

		if (keycode == KeyEvent.VK_R){
			this.controler.giveKey('R');
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {		
	}

	/**
	 * Unique identification.
	 *
	 * @return serialVersionUID.
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}