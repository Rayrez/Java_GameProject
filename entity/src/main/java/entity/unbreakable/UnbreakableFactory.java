package entity.unbreakable;

/**
 * Tha abstract class UnbreakableFactory
 *
 * @author Pierre GARRIDO
 */
public abstract class UnbreakableFactory {

	/**
	 * Instantiates a new Blue wall.
	 */
	private static final Unbreakable blueWall = new BlueWall();

	/**
	 * Instantiates a new Explosion.
	 */
	private static final Unbreakable explosion = new Explosion();

	/**
	 * Instantiates a new Grey wall.
	 */
	private static final Unbreakable greyWall = new GreyWall();

	/**
	 * Instantiates a Unbreakable.
	 */
	private static Unbreakable[] entities = {blueWall, explosion, greyWall};

	/**
	 * Create the Blue wall block.
	 *
	 * @return The blue wall's sprite.
	 */
	public Unbreakable createBlueWall() {
		return blueWall;
	}

	/**
	 * Create the explosion block.
	 *
	 * @return The explosion's sprite.
	 */
	public Unbreakable createExplosion() {
		return explosion;
	}

	/**
	 * Create the grey wall block.
	 *
	 * @return The grey wall's sprite.
	 */
	public Unbreakable createGreyWall() {
		return greyWall;
	}

	/**
	 * Gets the sprite from the symbols.
	 *
	 * @param symbol
	 * 			The symbol on the map file for the dirt.
	 * @return The sprite of the Blue wall or Grey wall or Explosion.
	 */
	public static Unbreakable getFromFileSymbol(char symbol) {
		int i = 1;
		for (final Unbreakable entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
                if(i == 1)
                	return new BlueWall();
                else if(i == 2)
                	return new Explosion();
                else if(i == 3)
                	return new GreyWall();
                else
                	return null;
            }
            i++;
        }
		return null;
	}

}
