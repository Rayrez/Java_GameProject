package entity.penetrable;

public abstract class PenetrableFactory {
	
	private static final Penetrable background = new Background();
	
	private static Penetrable[] entities = {background};
	
	public Penetrable createBackground() {
		return background;
	}
	
	public static Penetrable getFromFileSymbol(char symbol) {
		for (Penetrable entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
                return entity;
            }
        }
		return null;
	}

}