package view;

import contract.IController;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Class KeyListener.
 *
 * @author Bastien Aelters, Benjamin Brifault
 */
public class DashKeyListener implements KeyListener {


    /**
	 * 
	 */
	private static final long serialVersionUID = 6957355209405412190L;
	
	private IController controler;

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
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}