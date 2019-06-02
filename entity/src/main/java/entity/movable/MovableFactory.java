package entity.movable;

/**
 * The abstract class MovableFactory.
 *
 * @author Pierre GARRIDO
 */
public abstract class MovableFactory {

	/**
	 * Instantiates a new rock.
	 */
	private static final Movable rock = new Rock();

	/**
	 * Instantiates a new Movable.
	 */
	private static Movable[] entities = {rock};

	/**
	 * Create the rock block.
	 *
	 * @return rock.
	 */
	public Movable createRock() {
		return rock;
	}

	/**
	 * Gets the sprite from the symbols.
	 *
	 * @param symbol
	 * 			The symbol on the map file for the rock.
	 * @return the sprite of the rock.
	 */
	public static Movable getFromFileSymbol(char symbol) {
		int i = 1;
		for (final Movable entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
				if(i == 1)
					return new Rock();
				else
					return null;
            }
            i++;
        }
		return null;
	}

}
