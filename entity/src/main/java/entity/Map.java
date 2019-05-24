package entity;

public class Map {
	
	private Entity map[][];
	
	public Map(Entity elements[][]) {
		this.map = elements;
	}

	public Entity[][] getMap() {
		return this.map;
	}

}
