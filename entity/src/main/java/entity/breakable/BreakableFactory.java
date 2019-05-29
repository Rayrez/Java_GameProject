package entity.breakable;

public abstract class BreakableFactory {

	private static final Dirt dirt = new Dirt();
	
	private static Breakable[] entities = {dirt};
	
	public static Breakable createDirt() {
		return dirt;
	}
	
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
