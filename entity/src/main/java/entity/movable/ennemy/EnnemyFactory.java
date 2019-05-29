package entity.movable.ennemy;

public abstract class EnnemyFactory {
	
	private static final Ennemy octopus = new Octopus();
	
	private static Ennemy[] entities = {octopus};
	
	public Ennemy createOctopus() {
		return octopus;
	}
	
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
