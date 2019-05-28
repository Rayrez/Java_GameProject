package entity.movable;

public abstract class MovableFactory {
	
	private static Movable rock = new Rock();
	
	private static Movable[] entities = {rock};
	
	public Movable createRock() {
		return rock;
	}
	
	public Movable getFromFileSymbol(char symbol) {
		for (Movable entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
                return entity;
            }
        }
		return null;
	}

}
