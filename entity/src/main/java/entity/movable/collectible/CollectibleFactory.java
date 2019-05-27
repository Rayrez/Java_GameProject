package entity.movable.collectible;

public abstract class CollectibleFactory {
	
	private static Collectible diamond = new Diamond();
	
	private static Collectible[] entities = {diamond};
	
	public Collectible createDiamond() {
		return diamond;
	}
	
	public Collectible getFromFileSymbol(char symbol) {
		for (Collectible entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
                return entity;
            }
        }
		return null;
	}

}
