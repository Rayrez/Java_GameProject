package entity.breakable;

public abstract class BreakableFactory {
	
	private static final Dirt dirt = new Dirt();
	
	private static Breakable[] entities = {dirt};
	
	public static Breakable createDirt() {
		return dirt;
	}
	
	public static Breakable getFromFileSymbol(char symbol) {
		for (Breakable entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
                return entity;
            }
        }
		return null;
	}

}
