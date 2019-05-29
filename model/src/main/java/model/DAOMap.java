package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import entity.Entity;
import entity.breakable.Breakable;
import entity.breakable.BreakableFactory;
import entity.movable.Movable;
import entity.movable.MovableFactory;
import entity.movable.collectible.Collectible;
import entity.movable.collectible.CollectibleFactory;
import entity.movable.ennemy.Ennemy;
import entity.movable.ennemy.EnnemyFactory;
import entity.movable.heros.Heros;
import entity.penetrable.Background;
import entity.penetrable.Exit;
import entity.penetrable.Penetrable;
import entity.penetrable.PenetrableFactory;
import entity.unbreakable.Unbreakable;
import entity.unbreakable.UnbreakableFactory;

/**
 * The Class DAOMap.
 *
 * @author Pierre GARRIDO
 */
public class DAOMap {

	/** The connection. */
	private final Connection connection;

	/**
	 * Instantiates a new DAO entity.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMap(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}


	/**
	 * Load the maps.
	 *
	 * @param mapNumber
	 *          The number of the map
	 * @param movables
	 *          The movables
	 * @param collec
	 *          The collectibles
	 * @param heros
	 *          The heros
	 * @param enemies
	 *          The enemies
	 * @param penetrables
	 *          The penetrable
	 * @param unbreakables
	 *          The unbreakables
	 * @param breakables
	 *          The breakables          
	 * @throws SQLException
	 * @throws RuntimeException
	 */
	public Entity[][] load(int mapNumber, ArrayList<Movable> movables, ArrayList<Collectible> collec, Heros heros, ArrayList<Ennemy> enemies, ArrayList<Penetrable> penetrables, ArrayList<Unbreakable> unbreakables, ArrayList<Breakable> breakables, Exit exit) throws SQLException, RuntimeException {

		java.sql.PreparedStatement statement = this.connection.prepareStatement("CALL getMaps(?);");
		statement.setInt(1, mapNumber);
		
		ResultSet resul = statement.executeQuery();
		
		if(resul == null)
			throw new SQLException("Request execution failed");
		else
		{
			resul.next();
			
			String mapTxt = resul.getString("map");
			
			int x = 0, y = 0, i = 0;
			boolean fin = true;
			Entity[][] map = new Entity[25][28];

			while(fin) {

				if(BreakableFactory.getFromFileSymbol(mapTxt.charAt(i)) != null)
				{
					Breakable entity = BreakableFactory.getFromFileSymbol(mapTxt.charAt(i));
					entity.setXY(x, y);
					breakables.add(entity);
					map[x][y] = entity;
					x++;
				}
				else if(PenetrableFactory.getFromFileSymbol(mapTxt.charAt(i)) != null)
				{
					Penetrable entity = PenetrableFactory.getFromFileSymbol(mapTxt.charAt(i));
					entity.setXY(x, y);
					penetrables.add(entity);
					map[x][y] = entity;
					x++;
				}
				else if(UnbreakableFactory.getFromFileSymbol(mapTxt.charAt(i)) != null)
				{
					Unbreakable entity = UnbreakableFactory.getFromFileSymbol(mapTxt.charAt(i));
					entity.setXY(x, y);
					unbreakables.add(entity);
					map[x][y] = entity;
					x++;
				}
				else if(MovableFactory.getFromFileSymbol(mapTxt.charAt(i)) != null)
				{
					Movable entity = MovableFactory.getFromFileSymbol(mapTxt.charAt(i));
					entity.setXY(x, y);
					movables.add(entity);
					map[x][y] = entity;
					x++;
				}
				else if(CollectibleFactory.getFromFileSymbol(mapTxt.charAt(i)) != null)
				{
					Collectible entity = CollectibleFactory.getFromFileSymbol(mapTxt.charAt(i));
					entity.setXY(x, y);
					movables.add(entity);
					collec.add(entity);
					map[x][y] = entity;
					x++;
				}
				else if(EnnemyFactory.getFromFileSymbol(mapTxt.charAt(i)) != null)
				{
					Ennemy entity = EnnemyFactory.getFromFileSymbol(mapTxt.charAt(i));
					entity.setXY(x, y);
					movables.add(entity);
					enemies.add(entity);
					map[x][y] = entity;
					x++;
				}
				else if(mapTxt.charAt(i) == 'E')
				{
					exit = new Exit();
					exit.setXY(x, y);
					Background back = new Background();
					back.setXY(x, y);
					map[x][y] = back;
					x++;
				}
				else if(mapTxt.charAt(i) == 'H')
				{
					heros = new Heros();
					heros.setXY(x, y);
					map[x][y] = heros;
					x++;
				}
				else if(mapTxt.charAt(i) == 13)
				{
					x = 0;
				}
				else if(mapTxt.charAt(i) == 10)
				{
					x = 0;
					y++;
				}
				else
				{
					System.out.print((int) mapTxt.charAt(i));
					statement.close();
					throw new RuntimeException("Unknowed Sprite : "+ mapTxt.charAt(i));
				}

				i++;

				if(i >= mapTxt.length())
				{
					fin = false;
				}
			}
			statement.close();
			return map;
		}
	}

}
