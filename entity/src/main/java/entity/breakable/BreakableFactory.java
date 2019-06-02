package entity.breakable;

/**
 * The abstract class BreakableFactory.
 */
public abstract class BreakableFactory {

	/**
	 * Instantiates a new Dirt.
	 */
	private static final Dirt dirt = new Dirt();

	/**
	 * Instantiates  a new Breakable.
	 */
	private static Breakable[] entities = {dirt};

	/**
	 * Create the dirt block.
	 *
	 * @return dirt.
	 */
	public static Breakable createDirt() {
		return dirt;
	}

	/**
	 * Gets the sprite from the symbols.
	 *
	 * @param symbol
	 * 			The symbol on the map file for the dirt.
	 * @return the sprite of the dirt.
	 */
	public static Breakable getFromFileSymbol(char symbol) {
		int i = 1;
		for (final Breakable entity : entities) {
			if (entity.getBaseSprite().getIcon() == symbol) {
				if(i == 1)
					return new Dirt();
				else
					return null;
			}
			i++;
        }
		return null;
	}

}
