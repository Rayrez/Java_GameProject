package model;

import entity.Capacities;
import entity.movable.ennemy.Ennemy;
import entity.penetrable.Background;

public class MoveEnnemy implements Runnable {
	
	Ennemy ennemy;
	
	public MoveEnnemy(Ennemy e) {
		this.ennemy = e;
	}

	@Override
	public void run() {
		int dir = 1, i = 0;
		
		while(true) {
			if(dir == 1)
			{
				if(Model.map[ennemy.getX() + 1][ennemy.getY()].getCapacity() == Capacities.PENETRABLE)
				{
					dir = 3;
				}
				else if(Model.map[ennemy.getX()][ennemy.getY() + 1].getCapacity() != Capacities.PENETRABLE && Model.map[ennemy.getX() - 1][ennemy.getY() + 1].getCapacity() == Capacities.PENETRABLE)
				{
					dir = 4;
				}
				else if(Model.map[ennemy.getX()][ennemy.getY() + 1].getCapacity() != Capacities.PENETRABLE && Model.map[ennemy.getX() - 1][ennemy.getY() + 1].getCapacity() != Capacities.PENETRABLE)
				{
					Background b = new Background();
					b.setXY(ennemy.getX(), ennemy.getY());
					Model.map[ennemy.getX()][ennemy.getY()] = b;
					for(i = 0;i < Model.penetrables.size();i++)
					{
						if(Model.penetrables.get(i).getX() == ennemy.getX() && Model.penetrables.get(i).getY() == (ennemy.getY() + 1))
						{
							Model.penetrables.remove(i);
						}
					}
					ennemy.setY(ennemy.getY() + 1);
					Model.map[ennemy.getX()][ennemy.getY() + 1] = ennemy;
				}
			}
		}
	}

}
