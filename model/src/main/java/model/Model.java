package model;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import contract.*;
import entity.*;
import entity.breakable.Breakable;
import entity.breakable.Dirt;
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
public final class Model extends Observable implements IModel, Runnable {
	
	/**
	 * The class's attributes.
	 *
	 */
	private static Entity[][] map;
	private static int score;
	private static int diamonds_remaining;
	static ArrayList<Movable> mouv;
	static ArrayList<Collectible> collec;
	private static Heros heros;
	private static Exit exit;
	static ArrayList<Ennemy> enemies;
	static ArrayList<Penetrable> penetrables;
	private static ArrayList<Unbreakable> unbreakables;
	private static ArrayList<Breakable> breakables;
	private static boolean pause;
	private static int numberMap;
	private static Thread move_ennemy;
	private boolean change;

	/**
	 * Instantiates a new model.
	 *
	 * @param numberMapP;
	 */
	public Model(int numberMapP) {
		Model.numberMap = numberMapP;
		Model.score = 0;
		Model.mouv = new ArrayList<Movable>();
		Model.collec = new ArrayList<Collectible>();
		Model.enemies = new ArrayList<Ennemy>();
		Model.penetrables = new ArrayList<Penetrable>();
		Model.unbreakables = new ArrayList<Unbreakable>();
		Model.breakables = new ArrayList<Breakable>();
		this.loadMap(numberMap);		
		Model.diamonds_remaining = collec.size();
		move_ennemy = new Thread(this);
		move_ennemy.start();
	}

	/**
     * Load the initial map.
     *
	 * @param mapNumber;
	 *            the number of the map.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMap(entity.Entity)
	 */
	private void loadMap(int mapNumber) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			Model.map = daoMap.load(mapNumber, mouv, collec, enemies, penetrables, unbreakables, breakables);
			int x, y;
			for(x = 0;x < 25;x++)
			{
				for(y = 0;y < 28;y++)
				{
					if(map[x][y].getBaseSprite().getIcon() == 'H')
					{
						heros = new Heros();
						heros.setXY(x, y);
						map[x][y] = heros;
					}
					else if(map[x][y].getBaseSprite().getIcon() == 'E')
					{
						exit = new Exit();
						exit.setXY(x, y);
						Dirt d = new Dirt();
						d.setXY(x, y);
						map[x][y] = d;
					}
				}
			}
		} catch (final SQLException e) {
			e.printStackTrace();e.printStackTrace();
		} catch (final RuntimeException e2) {
			e2.printStackTrace();
		}
	}
	
	/**
     * Reset the model.
     */
	private void resetModel() {
		
		Model.mouv.removeAll(Model.mouv);
		Model.collec.removeAll(Model.collec);
		Model.heros = new Heros();
		Model.enemies.removeAll(Model.enemies);
		Model.penetrables.removeAll(Model.penetrables);
		Model.unbreakables.removeAll(Model.unbreakables);
		Model.map = null;
		this.loadMap(numberMap);
		move_ennemy = new Thread(this);
		move_ennemy.start();
		score = 0;
		this.setChanged();
		this.notifyObservers();
		pause = false;
	}

	/**
     * Gets the observable.
     *
     * @return the observable.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

	/**
	 * Gets the map.
	 *
	 * @return map.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMap()
	 */
	@Override
	public Entity[][] getMap() {
		return Model.map;
	}

	/**
	 * Gets if the player is dead.
	 *
	 * @return true if the player is dead.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#isDead()
	 */
	@Override
	public boolean isDead() {
		return heros.isAlive();
	}

	/**
	 * Gets if the player has won.
	 *
	 * @return true if the player has won.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#hasWon()
	 */
	@Override
	public boolean hasWon() {
		if(heros.getX() == exit.getX() && heros.getY() == exit.getY() && diamonds_remaining == 0)
			return true;
		else
			return false;
	}

	/**
	 * Permit to give order to the model.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#giveOrder()
	 */
	@Override
	public void giveOrder(ControllerOrder order) {

		if(!pause)
		{
			if(order == ControllerOrder.MoveLeft)
				this.moveLeft();
			else if(order == ControllerOrder.MoveRight)
				this.moveRight();
			else if(order == ControllerOrder.MoveUp)
				this.moveUp();
			else if(order == ControllerOrder.MoveDown)
				this.moveDown();
			if (order == ControllerOrder.Pause)
				pause = true;

			if(collec.size() == 0)
			{
				exit.setVisible(true);
				map[exit.getX()][exit.getY()] = exit;
				this.setChanged();
				this.notifyObservers();
			}

			if(heros.getX() == exit.getX() && heros.getY() == exit.getY() && diamonds_remaining == 0)
			{
				pause = true;
			}
		}
		else
		{
			if (order == ControllerOrder.Reset)
				this.resetModel();
			else if (order == ControllerOrder.Pause)
				pause = false;
		}
	}
	
	
	/**
	 * Move the player to the left.
	 */
	private void moveLeft() {
		
		if(map[heros.getX() - 1][heros.getY()].getCapacity() == Capacities.UNBREAKABLE)
		{
			heros.setDir(Direction.LEFT);
		}
		else if(map[heros.getX() - 1][heros.getY()].getCapacity() == Capacities.PENETRABLE)
		{
			if(exit.getX() == (heros.getX() - 1) && exit.getY() == heros.getY())
			{
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX() - 1][heros.getY()] = heros;
				map[heros.getX()][heros.getY()] = pen;
			}
			else
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
			}
			heros.setDir(Direction.LEFT);
			heros.setX(heros.getX() - 1);
			this.testFallMap();
		}
		else if(map[heros.getX() - 1][heros.getY()].getCapacity() == Capacities.COLLECTIBLE)
		{
			score += 50;
			int i = 0;
			for(i = 0;i < collec.size();i++)
			{
				if(collec.get(i).getX() == (heros.getX() - 1) && collec.get(i).getY() == heros.getY())
				{
					collec.remove(i);
				}
			}
			Penetrable pen = new Background();
			pen.setXY(heros.getX(), heros.getY());
			map[heros.getX() - 1][heros.getY()] = heros;
			map[heros.getX()][heros.getY()] = pen;
			diamonds_remaining = collec.size(); 
			penetrables.add(pen);
			heros.setDir(Direction.LEFT);
			heros.setX(heros.getX() - 1);
			this.testFallMap();
		}
		else if(map[heros.getX() - 1][heros.getY()].getCapacity() == Capacities.BREAKABLE)
		{
			if(exit.getX() == (heros.getX() - 1) && exit.getY() == heros.getY())
			{
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX() - 1][heros.getY()] = heros;
				map[heros.getX()][heros.getY()] = pen;
			}
			else
			{
				int i = 0;
				for(i = 0;i < breakables.size();i++)
				{
					if(breakables.get(i).getX() == (heros.getX() - 1) && breakables.get(i).getY() == heros.getY())
					{
						breakables.remove(i);
					}
				}
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX() - 1][heros.getY()] = heros;
				map[heros.getX()][heros.getY()] = pen;
				penetrables.add(pen);
			}
			heros.setDir(Direction.LEFT);
			heros.setX(heros.getX() - 1);
			this.testFallMap();
		}
		else if(map[heros.getX() - 1][heros.getY()].getCapacity() == Capacities.MOVABLE)
		{
			if((heros.getX() - 2) > 0)
			{
				if(map[heros.getX() - 2][heros.getY()].getCapacity() == Capacities.PENETRABLE)
				{
					int i = 0;
					Movable m = null;
					for(i = 0;i < mouv.size();i++)
					{
						if(mouv.get(i).getX() == (heros.getX() - 1) && mouv.get(i).getY() == heros.getY())
						{
							m = mouv.get(i);
						}
					}
					heros.setX(heros.getX() - 1);
					if(!this.checkKillHeros())
					{
						Penetrable pen = new Background();
						pen.setXY(heros.getX(), heros.getY());
						penetrables.add(pen);
						map[heros.getX()][heros.getY()] = pen;
						map[heros.getX() - 1][heros.getY()] = heros;
						map[heros.getX() - 2][heros.getY()] = m;
						m.setX(m.getX() - 1);
					}
				}
				this.testFallMap();
			}
			heros.setDir(Direction.LEFT);
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Move the player to the right.
	 */
	private void moveRight() {
		
		if(map[heros.getX() + 1][heros.getY()].getCapacity() == Capacities.UNBREAKABLE)
		{
			heros.setDir(Direction.RIGHT);
		}
		else if(map[heros.getX() + 1][heros.getY()].getCapacity() == Capacities.PENETRABLE)
		{
			if(exit.getX() == (heros.getX() + 1) && exit.getY() == heros.getY())
			{
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX() + 1][heros.getY()] = heros;
				map[heros.getX()][heros.getY()] = pen;
			}
			else
			{
				int i = 0;
				for(i = 0;i < penetrables.size();i++)
				{
					if(penetrables.get(i).getX() == (heros.getX() + 1) && penetrables.get(i).getY() == heros.getY())
					{
						penetrables.remove(i);
					}
				}
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX() + 1][heros.getY()] = heros;
				map[heros.getX()][heros.getY()] = pen;
				penetrables.add(pen);
			}
			heros.setDir(Direction.RIGHT);
			heros.setX(heros.getX() + 1);
			this.testFallMap();
		}
		else if(map[heros.getX() + 1][heros.getY()].getCapacity() == Capacities.COLLECTIBLE)
		{
			score += 50;
			int i = 0;
			for(i = 0;i < collec.size();i++)
			{
				if(collec.get(i).getX() == (heros.getX() + 1) && collec.get(i).getY() == heros.getY())
				{
					collec.remove(i);
				}
			}
			Penetrable pen = new Background();
			pen.setXY(heros.getX(), heros.getY());
			map[heros.getX() + 1][heros.getY()] = heros;
			map[heros.getX()][heros.getY()] = pen;
			diamonds_remaining = collec.size(); 
			penetrables.add(pen);
			heros.setDir(Direction.RIGHT);
			heros.setX(heros.getX() + 1);
			this.testFallMap();
		}
		else if(map[heros.getX() + 1][heros.getY()].getCapacity() == Capacities.BREAKABLE)
		{
			if(exit.getX() == (heros.getX() + 1) && exit.getY() == heros.getY())
			{
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX() + 1][heros.getY()] = heros;
				map[heros.getX()][heros.getY()] = pen;
			}
			else
			{
				int i = 0;
				for(i = 0;i < breakables.size();i++)
				{
					if(breakables.get(i).getX() == (heros.getX() + 1) && breakables.get(i).getY() == heros.getY())
					{
						breakables.remove(i);
					}
				}
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX() + 1][heros.getY()] = heros;
				map[heros.getX()][heros.getY()] = pen;
				penetrables.add(pen);
			}
			heros.setDir(Direction.RIGHT);
			heros.setX(heros.getX() + 1);
			this.testFallMap();
		}
		else if(map[heros.getX() + 1][heros.getY()].getCapacity() == Capacities.MOVABLE)
		{
			if((heros.getX() + 2) <= 25)
			{
				
				if(map[heros.getX() + 2][heros.getY()].getCapacity() == Capacities.PENETRABLE)
				{
					int i = 0;
					Movable m = null;
					for(i = 0;i < mouv.size();i++)
					{
						if(mouv.get(i).getX() == (heros.getX() + 1) && mouv.get(i).getY() == heros.getY())
						{
							m = mouv.get(i);
						}
					}
					heros.setX(heros.getX() + 1);
					if(!this.checkKillHeros())
					{
						Penetrable pen = new Background();
						pen.setXY(heros.getX(), heros.getY());
						penetrables.add(pen);
						map[heros.getX()][heros.getY()] = pen;
						map[heros.getX() + 1][heros.getY()] = heros;
						map[heros.getX() + 2][heros.getY()] = m;
						m.setX(m.getX() + 1);
					}
				}
				this.testFallMap();
			}
			heros.setDir(Direction.RIGHT);
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Move the player down.
	 */
	private void moveDown() {
		
		if(map[heros.getX()][heros.getY() + 1].getCapacity() == Capacities.UNBREAKABLE)
		{
			heros.setDir(Direction.FACE);
		}
		else if(map[heros.getX()][heros.getY() + 1].getCapacity() == Capacities.PENETRABLE)
		{
			if(exit.getX() == heros.getX() && exit.getY() == (heros.getY() + 1))
			{
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX()][heros.getY() + 1] = heros;
				map[heros.getX()][heros.getY()] = pen;
			}
			else
			{
				int i = 0;
				for(i = 0;i < penetrables.size();i++)
				{
					if(penetrables.get(i).getX() == heros.getX() && penetrables.get(i).getY() == (heros.getY()+1))
					{
						penetrables.remove(i);
					}
				}
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX()][heros.getY() + 1] = heros;
				map[heros.getX()][heros.getY()] = pen;
				penetrables.add(pen);
			}
			heros.setDir(Direction.FACE);
			heros.setY(heros.getY() + 1);
			this.testFallMap();
		}
		else if(map[heros.getX()][heros.getY() + 1].getCapacity() == Capacities.COLLECTIBLE)
		{
			score += 50;
			int i = 0;
			for(i = 0;i < collec.size();i++)
			{
				if(collec.get(i).getX() == heros.getX() && collec.get(i).getY() == (heros.getY()+1))
				{
					collec.remove(i);
				}
			}
			Penetrable pen = new Background();
			pen.setXY(heros.getX(), heros.getY());
			map[heros.getX()][heros.getY() + 1] = heros;
			map[heros.getX()][heros.getY()] = pen;
			diamonds_remaining = collec.size(); 
			penetrables.add(pen);
			heros.setDir(Direction.FACE);
			heros.setY(heros.getY() + 1);
			this.testFallMap();
		}
		else if(map[heros.getX()][heros.getY() + 1].getCapacity() == Capacities.BREAKABLE)
		{
			if(exit.getX() == heros.getX() && exit.getY() == (heros.getY() + 1))
			{
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX()][heros.getY() + 1] = heros;
				map[heros.getX()][heros.getY()] = pen;
			}
			else
			{
				int i = 0;
				for(i = 0;i < breakables.size();i++)
				{
					if(breakables.get(i).getX() == heros.getX() && breakables.get(i).getY() == (heros.getY() + 1))
					{
						breakables.remove(i);
					}
				}
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX()][heros.getY() + 1] = heros;
				map[heros.getX()][heros.getY()] = pen;
				penetrables.add(pen);
			}
			heros.setDir(Direction.FACE);
			heros.setY(heros.getY() + 1);
			this.testFallMap();
		}
		else if(map[heros.getX()][heros.getY() + 1].getCapacity() == Capacities.MOVABLE)
		{
			heros.setDir(Direction.FACE);
			this.checkKillHeros();
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Move the player up.
	 */
	private void moveUp() {
		
		if(map[heros.getX()][heros.getY() - 1].getCapacity() == Capacities.UNBREAKABLE)
		{
			heros.setDir(Direction.FACE);
		}
		else if(map[heros.getX()][heros.getY() - 1].getCapacity() == Capacities.PENETRABLE)
		{
			if(exit.getX() == heros.getX() && exit.getY() == (heros.getY() - 1))
			{
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX()][heros.getY() - 1] = heros;
				map[heros.getX()][heros.getY()] = pen;
			}
			else
			{
				int i = 0;
				for(i = 0;i < penetrables.size();i++)
				{
					if(penetrables.get(i).getX() == heros.getX() && penetrables.get(i).getY() == (heros.getY()-1))
					{
						penetrables.remove(i);
					}
				}
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX()][heros.getY() - 1] = heros;
				map[heros.getX()][heros.getY()] = pen;
				penetrables.add(pen);
			}
			heros.setDir(Direction.FACE);
			heros.setY(heros.getY() - 1);
			this.testFallMap();
		}
		else if(map[heros.getX()][heros.getY() - 1].getCapacity() == Capacities.COLLECTIBLE)
		{
			score += 50;
			int i = 0;
			for(i = 0;i < collec.size();i++)
			{
				if(collec.get(i).getX() == heros.getX() && collec.get(i).getY() == (heros.getY() - 1))
				{
					collec.remove(i);
				}
			}
			Penetrable pen = new Background();
			pen.setXY(heros.getX(), heros.getY());
			map[heros.getX()][heros.getY() - 1] = heros;
			map[heros.getX()][heros.getY()] = pen;
			diamonds_remaining = collec.size(); 
			penetrables.add(pen);
			heros.setDir(Direction.FACE);
			heros.setY(heros.getY() - 1);
			this.testFallMap();
		}
		else if(map[heros.getX()][heros.getY() - 1].getCapacity() == Capacities.BREAKABLE)
		{
			if(exit.getX() == heros.getX() && exit.getY() == (heros.getY() - 1))
			{
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX()][heros.getY() - 1] = heros;
				map[heros.getX()][heros.getY()] = pen;
			}
			else
			{
				int i = 0;
				for(i = 0;i < breakables.size();i++)
				{
					if(breakables.get(i).getX() == heros.getX() && breakables.get(i).getY() == (heros.getY() - 1))
					{
						breakables.remove(i);
					}
				}
				Penetrable pen = new Background();
				pen.setXY(heros.getX(), heros.getY());
				map[heros.getX()][heros.getY() - 1] = heros;
				map[heros.getX()][heros.getY()] = pen;
				penetrables.add(pen);
			}
			heros.setDir(Direction.FACE);
			heros.setY(heros.getY() - 1);
			this.testFallMap();
		}
		else if(map[heros.getX()][heros.getY() - 1].getCapacity() == Capacities.MOVABLE)
		{
			heros.setDir(Direction.FACE);
			this.checkKillHeros();
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Tests the map to find places to activate the gravity.
	 */
	private void testFallMap() {
		int x, y;
		
		for(y = 0;y < 28;y++)
		{
			for(x = 0;x < 25;x++)
			{
				if(map[x][y].getCapacity() == Capacities.MOVABLE || map[x][y].getCapacity() == Capacities.COLLECTIBLE)
				{
					for(Movable m : mouv)
					{
						if(m.getX() == x && m.getY() == y)
						{
							if(m.isSubmittedToGravity() && (map[x][y+1].getCapacity() == Capacities.PENETRABLE || ((map[x+1][y+1].getCapacity() == Capacities.PENETRABLE || map[x-1][y+1].getCapacity() == Capacities.PENETRABLE)) && (map[x-1][y].getCapacity() == Capacities.PENETRABLE || map[x+1][y].getCapacity() == Capacities.PENETRABLE)) && !m.isMoving()) {
								Thread t = new Thread(new Fall(m, this));
								t.start();
							}
						}
					}

					for(Movable m : collec)
					{
						if(m.getX() == x && m.getY() == y)
						{
							if(m.isSubmittedToGravity() && (map[x][y+1].getCapacity() == Capacities.PENETRABLE || ((map[x+1][y+1].getCapacity() == Capacities.PENETRABLE || map[x-1][y+1].getCapacity() == Capacities.PENETRABLE)) && (map[x-1][y].getCapacity() == Capacities.PENETRABLE || map[x+1][y].getCapacity() == Capacities.PENETRABLE)) && !m.isMoving()) {
								System.out.println("Good joob");
								Thread t = new Thread(new Fall(m, this));
								t.start();
							}
						}
					}
				}
			}
		}
		
	}


	/**
     * Gets the score.
     *
     * @return the score.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getScore()
	 */
	@Override
	public int getScore() {
		return Model.score;
	}

	/**
     * Gets the number of remaining diamonds.
     *
     * @return the number of remaining diamond.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getDiamonds_remaining()
	 */
	@Override
	public int getDiamonds_remaining() {
		return Model.diamonds_remaining;
	}

	/**
     * Add an observer.
     */
	@Override
	public void addObserver(Observer o) {
		super.addObserver(o);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
     * Gets if the game is paused.
     *
     * @return true if the game is paused.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#isPaused()
	 */
	@Override
	public boolean isPaused() {
		return pause;
	}
	
	/**
     * Kills the heros by an enemy.
     */
	void killHeros(Ennemy e) {
		e.killSb(heros);
		pause = true;

		Explosion ex = new Explosion();
		ex.setXY(heros.getX(), heros.getY());
		map[heros.getX()][heros.getY()] = ex;

		ex = new Explosion();
		ex.setXY(heros.getX(), heros.getY() + 1);
		map[heros.getX()][heros.getY() + 1] = ex;

		ex = new Explosion();
		ex.setXY(heros.getX(), heros.getY() - 1);
		map[heros.getX()][heros.getY() - 1] = ex;

		ex = new Explosion();
		ex.setXY(heros.getX() + 1, heros.getY());
		map[heros.getX() + 1][heros.getY()] = ex;

		ex = new Explosion();
		ex.setXY(heros.getX() + 1, heros.getY() + 1);
		map[heros.getX() + 1][heros.getY() + 1] = ex;

		ex = new Explosion();
		ex.setXY(heros.getX() + 1, heros.getY() - 1);
		map[heros.getX() + 1][heros.getY() - 1] = ex;

		ex = new Explosion();
		ex.setXY(heros.getX() - 1, heros.getY());
		map[heros.getX() - 1][heros.getY()] = ex;

		ex = new Explosion();
		ex.setXY(heros.getX() - 1, heros.getY() + 1);
		map[heros.getX() - 1][heros.getY() + 1] = ex;

		ex = new Explosion();
		ex.setXY(heros.getX() - 1, heros.getY() - 1);
		map[heros.getX() - 1][heros.getY() - 1] = ex;

		this.setChanged();
		this.notifyObservers();
	}
	
	/**
     * Kills the heros by a movable.
     */
	void killHeros(Movable e) {
		pause = true;
		
		Explosion ex = new Explosion();
		ex.setXY(heros.getX(), heros.getY());
		map[heros.getX()][heros.getY()] = ex;
		
		ex = new Explosion();
		ex.setXY(heros.getX(), heros.getY() + 1);
		map[heros.getX()][heros.getY() + 1] = ex;
		
		ex = new Explosion();
		ex.setXY(heros.getX(), heros.getY() - 1);
		map[heros.getX()][heros.getY() - 1] = ex;
		
		ex = new Explosion();
		ex.setXY(heros.getX() + 1, heros.getY());
		map[heros.getX() + 1][heros.getY()] = ex;
		
		ex = new Explosion();
		ex.setXY(heros.getX() + 1, heros.getY() + 1);
		map[heros.getX() + 1][heros.getY() + 1] = ex;
		
		ex = new Explosion();
		ex.setXY(heros.getX() + 1, heros.getY() - 1);
		map[heros.getX() + 1][heros.getY() - 1] = ex;
		
		ex = new Explosion();
		ex.setXY(heros.getX() - 1, heros.getY());
		map[heros.getX() - 1][heros.getY()] = ex;
		
		ex = new Explosion();
		ex.setXY(heros.getX() - 1, heros.getY() + 1);
		map[heros.getX() - 1][heros.getY() + 1] = ex;
		
		ex = new Explosion();
		ex.setXY(heros.getX() - 1, heros.getY() - 1);
		map[heros.getX() - 1][heros.getY() - 1] = ex;
		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
     * The thread to move automatically the enemies and to detect any changes.
     */
	@Override
	public void run() {
		
		long timestamp = 0L, timestamp2 = 0L;
		int i;
		
		while(true)
		{
			if((System.currentTimeMillis() - timestamp) > 500 && !pause)
			{
				for(Ennemy ennemy : enemies)
				{
					if(Model.map[ennemy.getX() + 1][ennemy.getY() - 1].getCapacity() != Capacities.PENETRABLE && Model.map[ennemy.getX()][ennemy.getY() - 1].getCapacity() == Capacities.PENETRABLE)
					{
						for(i = 0;i < Model.penetrables.size();i++)
						{
							if(Model.penetrables.get(i).getX() == ennemy.getX() && Model.penetrables.get(i).getY() == (ennemy.getY() - 1))
							{
								Model.penetrables.remove(i);
							}
						}
						Penetrable pen = new Background();
						pen.setXY(ennemy.getX(), ennemy.getY());
						Model.map[ennemy.getX()][ennemy.getY() - 1] = ennemy;
						Model.map[ennemy.getX()][ennemy.getY()] = pen;
						ennemy.setY(ennemy.getY() - 1);
						Model.penetrables.add(pen);	
					}
					else if(Model.map[ennemy.getX() - 1][ennemy.getY() - 1].getCapacity() != Capacities.PENETRABLE && Model.map[ennemy.getX() - 1][ennemy.getY()].getCapacity() == Capacities.PENETRABLE)
					{
						for(i = 0;i < Model.penetrables.size();i++)
						{
							if(Model.penetrables.get(i).getX() == (ennemy.getX() - 1) && Model.penetrables.get(i).getY() == ennemy.getY())
							{
								Model.penetrables.remove(i);
							}
						}
						Penetrable pen = new Background();
						pen.setXY(ennemy.getX(), ennemy.getY());
						Model.map[ennemy.getX() - 1][ennemy.getY()] = ennemy;
						Model.map[ennemy.getX()][ennemy.getY()] = pen;
						ennemy.setX(ennemy.getX() - 1);
						Model.penetrables.add(pen);	
					}
					else if(Model.map[ennemy.getX() - 1][ennemy.getY() + 1].getCapacity() != Capacities.PENETRABLE && Model.map[ennemy.getX()][ennemy.getY() + 1].getCapacity() == Capacities.PENETRABLE)
					{
						for(i = 0;i < Model.penetrables.size();i++)
						{
							if(Model.penetrables.get(i).getX() == ennemy.getX() && Model.penetrables.get(i).getY() == (ennemy.getY() + 1))
							{
								Model.penetrables.remove(i);
							}
						}
						Penetrable pen = new Background();
						pen.setXY(ennemy.getX(), ennemy.getY());
						Model.map[ennemy.getX()][ennemy.getY() + 1] = ennemy;
						Model.map[ennemy.getX()][ennemy.getY()] = pen;
						ennemy.setY(ennemy.getY() + 1);
						Model.penetrables.add(pen);	
					}
					else if(Model.map[ennemy.getX() + 1][ennemy.getY() + 1].getCapacity() != Capacities.PENETRABLE && Model.map[ennemy.getX() + 1][ennemy.getY()].getCapacity() == Capacities.PENETRABLE)
					{
						for(i = 0;i < Model.penetrables.size();i++)
						{
							if(Model.penetrables.get(i).getX() == (ennemy.getX() + 1) && Model.penetrables.get(i).getY() == ennemy.getY())
							{
								Model.penetrables.remove(i);
							}	
						}		
						Penetrable pen = new Background();
						pen.setXY(ennemy.getX(), ennemy.getY());
						Model.map[ennemy.getX() + 1][ennemy.getY()] = ennemy;
						Model.map[ennemy.getX()][ennemy.getY()] = pen;
						ennemy.setX(ennemy.getX() + 1);
						Model.penetrables.add(pen);	
					}

					this.checkKillHeros();
				
					timestamp = System.currentTimeMillis();
				}
			}

			if((System.currentTimeMillis() - timestamp2) > 50 && !pause && change)
			{
				this.testFallMap();
				this.setChanged();
				this.notifyObservers();
				change = false;
			}
		}
	}
	
	/**
     * Checks if the hero is going to be killed.
     
     * @return true if the heros is going to be killed.
     */
	private boolean checkKillHeros() {
		
		boolean test = false;
		
		for(Ennemy ennemy : enemies)
		{
			if(heros.getX() == ennemy.getX() && heros.getY() == ennemy.getY())
			{
				this.killHeros(ennemy);
				test = true;
			}
			else if(heros.getX() == (ennemy.getX() - 1) && heros.getY() == ennemy.getY())
			{
				this.killHeros(ennemy);
				test = true;
			}
			else if(heros.getX() == (ennemy.getX() + 1) && heros.getY() == ennemy.getY())
			{
				this.killHeros(ennemy);
				test = true;
			}
			else if(heros.getX() == ennemy.getX() && heros.getY() == (ennemy.getY() + 1))
			{
				this.killHeros(ennemy);
				test = true;
			}
			else if(heros.getX() == ennemy.getX() && heros.getY() == (ennemy.getY() - 1))
			{
				this.killHeros(ennemy);
				test = true;
			}	
		}
		
		this.setChanged();
		this.notifyObservers();
		
		return test;
	}
	
	/**
     * Kills an enemy.
     */
	public void killEnnemy(Ennemy e) {
		int i;
		
		for(i = 0;i < enemies.size();i++)
		{
			if(e.getX() == enemies.get(i).getX() && e.getY() == enemies.get(i).getY())
			{
				e.kill();
				enemies.remove(i);
				
				Diamond dia = new Diamond();
				dia.setXY(e.getX(), e.getY());
				if(heros.getX() == dia.getX() && heros.getY() == dia.getY())
					this.killHeros(dia);
				map[e.getX()][e.getY()] = dia;
				
				dia = new Diamond();
				dia.setXY(e.getX(), e.getY() + 1);
				if(heros.getX() == dia.getX() && heros.getY() == dia.getY())
					this.killHeros(dia);
				map[e.getX()][e.getY() + 1] = dia;
				
				dia = new Diamond();
				dia.setXY(e.getX(), e.getY() - 1);
				if(heros.getX() == dia.getX() && heros.getY() == dia.getY())
					this.killHeros(dia);
				map[e.getX()][e.getY() - 1] = dia;
				
				dia = new Diamond();
				dia.setXY(e.getX() + 1, e.getY());
				if(heros.getX() == dia.getX() && heros.getY() == dia.getY())
					this.killHeros(dia);
				map[e.getX() + 1][e.getY()] = dia;
				
				dia = new Diamond();
				dia.setXY(e.getX() + 1, e.getY() + 1);
				if(heros.getX() == dia.getX() && heros.getY() == dia.getY())
					this.killHeros(dia);
				map[e.getX() + 1][e.getY() + 1] = dia;
				
				dia = new Diamond();
				dia.setXY(e.getX() + 1, e.getY() - 1);
				if(heros.getX() == dia.getX() && heros.getY() == dia.getY())
					this.killHeros(dia);
				map[e.getX() + 1][e.getY() - 1] = dia;
				
				dia = new Diamond();
				dia.setXY(e.getX() - 1, e.getY());
				if(heros.getX() == dia.getX() && heros.getY() == dia.getY())
					this.killHeros(dia);
				map[e.getX() - 1][e.getY()] = dia;
				
				dia = new Diamond();
				dia.setXY(e.getX() - 1, e.getY() + 1);
				if(heros.getX() == dia.getX() && heros.getY() == dia.getY())
					this.killHeros(dia);
				map[e.getX() - 1][e.getY() + 1] = dia;
				
				dia = new Diamond();
				dia.setXY(e.getX() - 1, e.getY() - 1);
				if(heros.getX() == dia.getX() && heros.getY() == dia.getY())
					this.killHeros(dia);
				map[e.getX() - 1][e.getY() - 1] = dia;
			}
		}
	}

	/**
     * Gets the hero's X position.
     *
     * @return the hero's X position.
     */
	int getHerosX() {
		return heros.getX();
	}

	/**
     * Gets the hero's Y position.
     *
     * @return the hero's Y position.
     */
	int getHerosY() {
		return heros.getY();
	}

	/**
     * Gets the entity within the map on a specific position.
     *
     * @return the entity
     */
	Entity getElement(int x, int y) {
		if(x > 25 || y > 28)
			throw new IllegalArgumentException("One of the values is too large");
		return map[x][y];
	}
	
	/**
     * Permits to set two entity within the map.

     */
	void setElement(Entity e1, Entity e2, int x1, int y1, int x2, int y2) {
		if(x1 > 25 || y2 > 28 || x2 > 25 || y2 > 28)
			throw new IllegalArgumentException("One of the values is too large");
		map[x1][y1] = e1;
		map[x2][y2] = e2;
		change = true;
	}
}
