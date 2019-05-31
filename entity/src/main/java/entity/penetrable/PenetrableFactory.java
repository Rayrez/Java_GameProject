package entity.penetrable;

/**
 * The abstract class PenetrableFactory
 *
 * @author Pierre GARRIDO
 */
public abstract class PenetrableFactory {

	/**
	 * Instantiates a new background
	 */
	private static final Penetrable background = new Background();

	/**
	 * Instantiates a new Penetrable
	 */
	private static Penetrable[] entities = {background};

	/**
	 * Create the background block
	 *
	 * @return The background's sprite
	 */
	public Penetrable createBackground() {
		return background;
	}

	/**
	 * Gets the sprite from the symbols
	 *
	 * @param symbol
	 * 			The symbol on the map file for the dirt
	 * @return The sprite of the background.
	 */
	public static Penetrable getFromFileSymbol(char symbol) {
		int i = 1;
		for (final Penetrable entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
				if(i == 1)
					return new Background();
				else
					return null;
            }
            i++;
        }
		return null;
	}

}