package entity.movable.collectible;

public abstract class CollectibleFactory {
	
	private static final Collectible diamond = new Diamond();
	
	private static Collectible[] entities = {diamond};
	
	public Collectible createDiamond() {
		return diamond;
	}
	
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
