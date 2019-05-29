package view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import contract.*;

import entity.Entity;


/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View extends JFrame implements IView, Runnable, Observer {

	private final IModel model;

	public View(IModel model) {
		this.model = model;

		this.setTitle("Boulder Dash");
		this.setSize(407, 510);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JButton("Pause"), BorderLayout.SOUTH);
		this.setVisible(true);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
	}

	@Override
	public void update(Observable o, Object arg) {
		model.getScore();
		model.getDiamonds_remaining();

		Entity[][] map = model.getMap();

		int x = 0, y = 0;

		for(x = 0;x < 25;x++)
		{
			for(y = 0;y < 28;y++)
			{
				map[x][y].getBaseSprite().getImage();
			}
		}
	}
}
