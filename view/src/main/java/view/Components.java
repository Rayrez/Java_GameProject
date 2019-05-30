package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IModel;
import entity.Entity;

public class Components extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1656551668798903799L;
	private Entity[][] map;
	private IModel model;
	
	public Components(IModel modelP) {
		super();
		this.model = modelP;
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

	@Override
	public void update(Observable o, Object arg) {
		this.model.getScore();
		this.model.getDiamonds_remaining();

		this.map = this.model.getMap();

		this.repaint();
	}

}
