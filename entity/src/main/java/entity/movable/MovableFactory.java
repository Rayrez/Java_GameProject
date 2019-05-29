package entity.movable;

public abstract class MovableFactory {
	
	private static final Movable rock = new Rock();
	
	private static Movable[] entities = {rock};
	
	public Movable createRock() {
		return rock;
	}
	
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
