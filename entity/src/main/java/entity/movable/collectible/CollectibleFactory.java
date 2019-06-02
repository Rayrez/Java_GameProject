package entity.movable.collectible;

/**
 * The abstract class Collectible.
 *
 * @author Pierre GARRIDO
 */
public abstract class CollectibleFactory {

	/**
	 * Instantiates a new diamond.
	 */
	private static final Collectible diamond = new Diamond();

	/**
	 * Instantiates a new collectible.
	 */
	private static Collectible[] entities = {diamond};

	/**
	 * Create a diamond.
	 *
	 * @return The diamond block.
	 */
	public Collectible createDiamond() {
		return diamond;
	}

	/**
	 * Gets the sprite from the symbols.
	 *
	 * @param symbol;
	 * 			The symbol on the map file for the diamond.
	 * @return the sprite of the diamond.
	 */
	public static Collectible getFromFileSymbol(char symbol) {
		int i = 1;
		for (final Collectible entity : entities) {
			if (entity.getBaseSprite().getIcon() == symbol) {
				if(i == 1)
					return new Diamond();
				else
					return null;
			}
			i++;
        }
		return null;
	}

}
