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
	private Entity[][] map;

	public View(IModel model) {
		this.model = model;
		this.setTitle("Boulder Dash");
		this.setSize(407, 510);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JButton("Pause"), BorderLayout.SOUTH);
		this.map = this.model.getMap();
		this.setVisible(true);
		this.model.getObservable().addObserver(this);
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

	@Override
	protected void paintComponent(final Graphics g) {
		int x, y;

		for(x = 0;x < 25;x++)
		{
			for(y = 0;y < 28;y++)
			{
				g.drawImage(this.map[x][y].getBaseSprite().getImage(), x * 16, y * 16, this);
			}
		}
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
		this.model.getScore();
		this.model.getDiamonds_remaining();

		this.map = this.model.getMap();

		this.repaint();
	}
}
