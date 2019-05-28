package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Entity;
import entity.movable.Movable;
import entity.movable.collectible.Collectible;
import entity.movable.ennemy.Ennemy;
import entity.movable.heros.Heros;
import entity.penetrable.Penetrable;
import entity.unbreakable.Unbreakable;

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
	 * @param map
	 *          The map
	 * @param mouv
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
	 */
	public void load(int mapNumber, Entity[][] map, ArrayList<Movable> mouv, ArrayList<Collectible> collec, Heros heros, ArrayList<Ennemy> enemies, ArrayList<Penetrable> penetrables, ArrayList<Unbreakable> unbreakables) {
		
	}

}
