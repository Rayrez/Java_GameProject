package entity.movable.ennemy;

/**
 * The abstract class EnnemyFactory.
 *
 * @author Pierre GARRIDO
 */
public abstract class EnnemyFactory {

	/**
	 * Instantiates a new octopus.
	 */
	private static final Ennemy octopus = new Octopus();

	/**
	 * Instantiates a new ennemy.
	 */
	private static Ennemy[] entities = {octopus};

	/**
	 * Create the octopus.
	 *
	 * @return octopus.
	 */
	public Ennemy createOctopus() {
		return octopus;
	}

	/**
	 * Gets the sprite from the symbols.
	 *
	 * @param symbol;
	 * 			The symbol on the map file for the octopus.
	 * @return the sprite of the octopus.
	 */
	public static Ennemy getFromFileSymbol(char symbol) {
		int i = 1;
		for (final Ennemy entity : entities) {
			if (entity.getBaseSprite().getIcon() == symbol) {
				if(i == 1)
					return new Octopus();
				else
					return null;
			}
			i++;
        }
		return null;
	}

}
