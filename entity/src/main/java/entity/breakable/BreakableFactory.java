package entity.breakable;

public abstract class BreakableFactory {
	
	private static Dirt dirt = new Dirt();
	
	private static Breakable[] entities = {dirt};
	
	public Breakable createDirt() {
		return dirt;
	}
	
	public Breakable getFromFileSymbol(char symbol) {
		for (Breakable entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
                return entity;
            }
        }
		return null;
	}

}