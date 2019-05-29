package entity.unbreakable;

public abstract class UnbreakableFactory {
	
	private static final Unbreakable blueWall = new BlueWall();
	private static final Unbreakable explosion = new Explosion();
	private static final Unbreakable greyWall = new GreyWall();

	private static Unbreakable[] entities = {blueWall, explosion, greyWall};
	
	public Unbreakable createBlueWall() {
		return blueWall;
	}
	
	public Unbreakable createExplosion() {
		return explosion;
	}
	
	public Unbreakable createGreyWall() {
		return greyWall;
	}
	
	public static Unbreakable getFromFileSymbol(char symbol) {
		for (Unbreakable entity : entities) {
            if (entity.getBaseSprite().getIcon() == symbol) {
                return entity;
            }
        }
		return null;
	}

}
