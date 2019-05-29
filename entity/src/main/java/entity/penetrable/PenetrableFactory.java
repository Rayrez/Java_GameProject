package entity.penetrable;

public abstract class PenetrableFactory {
	
	private static final Penetrable background = new Background();
	
	private static Penetrable[] entities = {background};
	
	public Penetrable createBackground() {
		return background;
	}
	
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