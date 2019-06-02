package model;

import entity.Capacities;
import entity.movable.ennemy.Ennemy;
import entity.penetrable.Background;
import entity.penetrable.Penetrable;

public class MoveEnnemy implements Runnable {
	
	private Ennemy ennemy;
	private long timestamp = 0L;
	
	public MoveEnnemy(Ennemy e) {
		this.ennemy = e;
	}

	@Override
	public void run() {
		timestamp = System.currentTimeMillis();
		int i = 0;
		boolean run = true;
		
		while(run) {
			
			/*if((System.currentTimeMillis() - timestamp) > 500)
			{
				if(Model.map[ennemy.getX() + 1][ennemy.getY() - 1].getCapacity() == Capacities.BREAKABLE && Model.map[ennemy.getX()][ennemy.getY() - 1].getCapacity() == Capacities.PENETRABLE)
				{
					for(i = 0;i < Model.penetrables.size();i++)
					{
						if(Model.penetrables.get(i).getX() == ennemy.getX() && Model.penetrables.get(i).getY() == (ennemy.getY() - 1))
						{
							Model.penetrables.remove(i);
						}
					}
					Penetrable pen = new Background();
					pen.setXY(ennemy.getX(), ennemy.getY());
					Model.map[ennemy.getX()][ennemy.getY() - 1] = ennemy;
					Model.map[ennemy.getX()][ennemy.getY()] = pen;
					ennemy.setY(ennemy.getY() - 1);
					Model.penetrables.add(pen);	
				}
				else if(Model.map[ennemy.getX() - 1][ennemy.getY() - 1].getCapacity() == Capacities.BREAKABLE && Model.map[ennemy.getX() - 1][ennemy.getY()].getCapacity() == Capacities.PENETRABLE)
				{
					for(i = 0;i < Model.penetrables.size();i++)
					{
						if(Model.penetrables.get(i).getX() == (ennemy.getX() - 1) && Model.penetrables.get(i).getY() == ennemy.getY())
						{
							Model.penetrables.remove(i);
						}
					}
					Penetrable pen = new Background();
					pen.setXY(ennemy.getX(), ennemy.getY());
					Model.map[ennemy.getX() - 1][ennemy.getY()] = ennemy;
					Model.map[ennemy.getX()][ennemy.getY()] = pen;
					ennemy.setX(ennemy.getX() - 1);
					Model.penetrables.add(pen);	
				}
				else if(Model.map[ennemy.getX() - 1][ennemy.getY() + 1].getCapacity() == Capacities.BREAKABLE && Model.map[ennemy.getX()][ennemy.getY() + 1].getCapacity() == Capacities.PENETRABLE)
				{
					for(i = 0;i < Model.penetrables.size();i++)
					{
						if(Model.penetrables.get(i).getX() == ennemy.getX() && Model.penetrables.get(i).getY() == (ennemy.getY() + 1))
						{
							Model.penetrables.remove(i);
						}
					}
					Penetrable pen = new Background();
					pen.setXY(ennemy.getX(), ennemy.getY());
					Model.map[ennemy.getX()][ennemy.getY() + 1] = ennemy;
					Model.map[ennemy.getX()][ennemy.getY()] = pen;
					ennemy.setY(ennemy.getY() + 1);
					Model.penetrables.add(pen);	
				}
				else if(Model.map[ennemy.getX() + 1][ennemy.getY() + 1].getCapacity() == Capacities.BREAKABLE && Model.map[ennemy.getX() + 1][ennemy.getY()].getCapacity() == Capacities.PENETRABLE)
				{
					for(i = 0;i < Model.penetrables.size();i++)
					{
						if(Model.penetrables.get(i).getX() == (ennemy.getX() + 1) && Model.penetrables.get(i).getY() == ennemy.getY())
						{
							Model.penetrables.remove(i);
						}
					}
					Penetrable pen = new Background();
					pen.setXY(ennemy.getX(), ennemy.getY());
					Model.map[ennemy.getX() + 1][ennemy.getY()] = ennemy;
					Model.map[ennemy.getX()][ennemy.getY()] = pen;
					ennemy.setX(ennemy.getX() + 1);
					Model.penetrables.add(pen);	
				}
				timestamp = System.currentTimeMillis();
				Model.setEnnemyMove();
			}*/
			
			if(Model.getHerosX() == ennemy.getX() && Model.getHerosX() == ennemy.getY())
			{
				Model.killHeros(ennemy);
			}
			else if(Model.getHerosX() == (ennemy.getX() - 1) && Model.getHerosX() == ennemy.getY())
			{
				Model.killHeros(ennemy);
			}
			else if(Model.getHerosX() == (ennemy.getX() + 1) && Model.getHerosX() == ennemy.getY())
			{
				Model.killHeros(ennemy);
			}
			else if(Model.getHerosX() == ennemy.getX() && Model.getHerosX() == (ennemy.getY() + 1))
			{
				Model.killHeros(ennemy);
			}
			else if(Model.getHerosX() == ennemy.getX() && Model.getHerosX() == (ennemy.getY() - 1))
			{
				Model.killHeros(ennemy);
			}
			
		}
	}

}
