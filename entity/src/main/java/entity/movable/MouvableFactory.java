package entity.movable;

public abstract class MouvableFactory {
	
	private static Mouvable rock = new Rock();
	
	private static Mouvable[] entities = {rock};
	
	public Mouvable createRock() {
		return rock;
	}
	
	public Mouvable getFromFileSymbol(char symbol) {
		for (Mouvable entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
                return entity;
            }
        }
		return null;
	}

}
