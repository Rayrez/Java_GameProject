package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.*;
import entity.*;
import entity.movable.*;
import entity.movable.collectible.*;
import entity.movable.ennemy.*;
import entity.movable.heros.Heros;
import entity.penetrable.*;
import entity.unbreakable.*;
/**
 * The Class Model.
 *
 * @author Pierre GARRIDO
 */
public final class Model extends Observable implements IModel {
	
	private Entity[][] map;
	private int score;
	private int diamonds_remaining;
	private ArrayList<Movable> mouv;
	private ArrayList<Collectible> collec;
	private Heros heros;
	private ArrayList<Ennemy> enemies;
	private ArrayList<Penetrable> penetrables;
	private ArrayList<Unbreakable> unbreakables;
	private boolean pause;

	/**
	 * Instantiates a new model.
	 */
	public Model(int numberMapP) {
		this.score = 0;
		this.mouv = new ArrayList<Movable>();
		this.collec = new ArrayList<Collectible>();;
		this.heros = new Heros();
		this.enemies = new ArrayList<Ennemy>();
		this.penetrables = new ArrayList<Penetrable>();
		this.unbreakables = new ArrayList<Unbreakable>();
		this.loadMap(numberMapP);
	}

	/**
     * Load the initial map.
     *
     * @param mapNumer
     *            the number of the map
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMap(entity.Entity)
	 */
	private void loadMap(int mapNumber) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			daoMap.load(mapNumber, map, mouv, collec, heros, enemies, penetrables, unbreakables);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Reset the model
     */
	private void resetModel() {
		
		this.mouv.removeAll(this.mouv);
		this.collec.removeAll(this.collec);
		this.heros = new Heros();
		this.enemies.removeAll(this.enemies);
		this.penetrables.removeAll(this.penetrables);
		this.unbreakables.removeAll(this.unbreakables);
		this.map = null;
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	/**
     * Gets the map.
     *
     * @return the map
     */
	@Override
	public Entity[][] getMap() {
		return this.map;
	}
	
	/**
     * Manage orders
     */
	@Override
	public void giveOrder(ControllerOrder order) {
		
		if(order == ControllerOrder.Pause)
		{
			if(pause)
				pause = false;
			else
				pause = true;
		}
		else
		{
			if(!pause)
			{
				if(order == ControllerOrder.MoveRight)
				{
					if(map[heros.getX() - 1][heros.getY()].getCapacity() == Capacities.UNBREAKABLE)
					{
						heros.setDir(Direction.RIGHT);
					}
					else if((map[heros.getX() - 1][heros.getY()].getCapacity() == Capacities.PENETRABLE))
					{
						int i = 0;
						for(i = 0;i < penetrables.size();i++)
						{
							if(penetrables.get(i).getX() == (heros.getX() - 1) && penetrables.get(i).getY() == heros.getY())
							{
								penetrables.remove(i);
							}
						}
						Penetrable pen = new Background();
						pen.setXY(heros.getX(), heros.getY());
						map[heros.getX() - 1][heros.getY()] = heros;
						map[heros.getX()][heros.getY()] = pen;
						penetrables.add(pen);
						heros.setDir(Direction.RIGHT);
						heros.setX(heros.getX() - 1);
					}
				}
			}
		}
	}

	/**
     * Gets the score.
     *
     * @return the score
     */
	@Override
	public int getScore() {
		return this.score;
	}

	/**
     * Gets the number of remaining diamonds.
     *
     * @return the number of remaining diamond
     */
	@Override
	public int getDiamonds_remaining() {
		return this.diamonds_remaining;
	}
}
