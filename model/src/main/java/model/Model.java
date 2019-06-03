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
	
	static Entity[][] map;
	private static int score;
	private static int diamonds_remaining;
	private static ArrayList<Movable> mouv;
	private static ArrayList<Collectible> collec;
	private static Heros heros;
	private static Exit exit;
	private static ArrayList<Ennemy> enemies;
	private static ArrayList<Penetrable> penetrables;
	private static ArrayList<Unbreakable> unbreakables;
	private static ArrayList<Breakable> breakables;
	private static boolean pause;
	private static int numberMap;
	private static Thread move_ennemy;

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
		Thread move_ennemy = new Thread(this);
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
	@SuppressWarnings("deprecation")
	private void resetModel() {
		
		move_ennemy.stop();
		Model.mouv.removeAll(Model.mouv);
		Model.collec.removeAll(Model.collec);
		Model.heros = new Heros();
		Model.enemies.removeAll(Model.enemies);
		Model.penetrables.removeAll(Model.penetrables);
		Model.unbreakables.removeAll(Model.unbreakables);
		Model.map = null;
		this.loadMap(numberMap);
		move_ennemy.start();
		this.setChanged();
		this.notifyObservers();;
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
	public Observable getObservable() {
		return this;
	}

	@Override
	public Entity[][] getMap() {
		return Model.map;
	}

	@Override
	public boolean isDead() {
		return heros.isAlive();
	}

	@Override
	public boolean hasWon() {
		if(heros.getX() == exit.getX() && heros.getY() == exit.getY() && diamonds_remaining == 0)
			return true;
		else
			return false;
	}

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
				if(order == ControllerOrder.MoveLeft)
					this.moveLeft();
				else if(order == ControllerOrder.MoveRight)
					this.moveRight();
				else if(order == ControllerOrder.MoveUp)
					this.moveUp();
				else if(order == ControllerOrder.MoveDown)
					this.moveDown();
				else if(order == ControllerOrder.Pause)
					pause = true;
				else if(order == ControllerOrder.Reset)
					this.resetModel();
				
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
		}
	}
	
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
			heros.setDir(Direction.RIGHT);
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
			heros.setDir(Direction.RIGHT);
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
	
	private void testFallMap() {
		
	}


	/**
     * Gets the score.
     *
     * @return the score.
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
	@Override
	public int getDiamonds_remaining() {
		return Model.diamonds_remaining;
	}

	@Override
	public void addObserver(Observer o) {
		super.addObserver(o);
		this.setChanged();
		this.notifyObservers();
	}
	
	@Override
	public boolean isPaused() {
		return pause;
	}
	
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

	@Override
	public void run() {
		
		long timestamp = 0L;
		int i;
		
		System.out.print("Run\n");
		
		while(true)
		{
			if((System.currentTimeMillis() - timestamp) > 500)
			{
				for(Ennemy ennemy : enemies)
				{
					if(Model.map[ennemy.getX() + 1][ennemy.getY() - 1].getCapacity() == Capacities.BREAKABLE && Model.map[ennemy.getX()][ennemy.getY() - 1].getCapacity() == Capacities.PENETRABLE)
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
					else if(Model.map[ennemy.getX() - 1][ennemy.getY() - 1].getCapacity() == Capacities.BREAKABLE && Model.map[ennemy.getX() - 1][ennemy.getY()].getCapacity() == Capacities.PENETRABLE)
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
					else if(Model.map[ennemy.getX() - 1][ennemy.getY() + 1].getCapacity() == Capacities.BREAKABLE && Model.map[ennemy.getX()][ennemy.getY() + 1].getCapacity() == Capacities.PENETRABLE)
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
					else if(Model.map[ennemy.getX() + 1][ennemy.getY() + 1].getCapacity() == Capacities.BREAKABLE && Model.map[ennemy.getX() + 1][ennemy.getY()].getCapacity() == Capacities.PENETRABLE)
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
					
					this.setChanged();
					this.notifyObservers();
				
					this.checkKillHeros();
				
					timestamp = System.currentTimeMillis();
				}
			}
		}
	}
	
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
}
