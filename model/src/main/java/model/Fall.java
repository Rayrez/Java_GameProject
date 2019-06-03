package model;

import entity.Capacities;
import entity.movable.Movable;
import entity.movable.ennemy.Ennemy;
import entity.penetrable.Background;
import entity.penetrable.Penetrable;

public class Fall implements Runnable {

	private Movable entity;
	private final Model model;
	
	public Fall(Movable e, Model m) {
		this.entity = e;
		this.model = m;
	}
	
	@Override
	public void run() {
		
		if(model.getElement(entity.getX(), entity.getY() + 1).getCapacity() == Capacities.PENETRABLE)
		{
			this.entity.setMoving(true);
			while(model.getElement(entity.getX(), entity.getY() + 1).getCapacity() == Capacities.PENETRABLE)
			{
				Penetrable pen = new Background();
				pen.setXY(entity.getX(), entity.getY());
				model.penetrables.add(pen);
				model.setElement(entity, pen, entity.getX(), entity.getY() + 1, entity.getX(), entity.getY());
				int i;
				for(i = 0;i < Model.penetrables.size();i++)
				{
					if(model.penetrables.get(i).getX() == entity.getX() && model.penetrables.get(i).getY() == (entity.getY() + 1))
					{
						model.penetrables.remove(i);
					}
				}
				entity.setY(entity.getY() + 1);
				entity.becomeMortal();
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if(model.getHerosX() == entity.getX() && model.getHerosY() == (entity.getY() + 1) && entity.isMortal())
			{
				model.killHeros(entity);
			}

			for(Ennemy en : Model.enemies)
			{
				if(en.getX() == entity.getX() && en.getY() == (entity.getY() + 1) && entity.isMortal())
				{
					model.killEnnemy(en);
					int i;
					for(i = 0;i < Model.mouv.size();i++)
					{
						if(Model.mouv.get(i).getX() == entity.getX() && Model.mouv.get(i).getY() == entity.getY())
						{
							Model.mouv.remove(i);
						}
					}
				}
			}
			this.entity.setMoving(false);
		}
		else if((model.getElement(entity.getX() + 1, entity.getY() + 1).getCapacity() == Capacities.PENETRABLE || model.getElement(entity.getX() - 1, entity.getY() + 1).getCapacity() == Capacities.PENETRABLE) && (model.getElement(entity.getX() - 1, entity.getY()).getCapacity() == Capacities.PENETRABLE || model.getElement(entity.getX() + 1, entity.getY()).getCapacity() == Capacities.PENETRABLE))
		{
			this.entity.setMoving(true);
			boolean ok = false;

			for(Movable m : Model.mouv)
			{
				if(m.getX() == entity.getX() && m.getY() == (entity.getY() + 1))
				{
					ok = true;
				}
			}

			for(Movable m : Model.collec)
			{
				if(m.getX() == entity.getX() && m.getY() == (entity.getY() + 1))
				{
					ok = true;
				}
			}

			if(model.getElement(entity.getX() + 1, entity.getY() + 1).getCapacity() == Capacities.PENETRABLE && model.getElement(entity.getX() + 1, entity.getY()).getCapacity() == Capacities.PENETRABLE && ok)
			{
				Penetrable pen = new Background();
				pen.setXY(entity.getX(), entity.getY());
				model.penetrables.add(pen);
                int i;
                for(i = 0;i < Model.penetrables.size();i++)
                {
                    if(model.penetrables.get(i).getX() == entity.getX() && model.penetrables.get(i).getY() == (entity.getY() + 1))
                    {
                        model.penetrables.remove(i);
                    }
                }
				model.setElement(entity, pen, entity.getX() + 1, entity.getY(), entity.getX(), entity.getY());
				entity.setX(entity.getX() + 1);
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Thread t = new Thread(new Fall(entity, this.model));
				t.start();
				this.entity.setMoving(false);
			}
			if(model.getElement(entity.getX() - 1, entity.getY() + 1).getCapacity() == Capacities.PENETRABLE && model.getElement(entity.getX() - 1, entity.getY()).getCapacity() == Capacities.PENETRABLE && ok) {
				Penetrable pen = new Background();
				pen.setXY(entity.getX(), entity.getY());
				model.penetrables.add(pen);
				int i;
				for (i = 0; i < Model.penetrables.size(); i++) {
					if (model.penetrables.get(i).getX() == entity.getX() && model.penetrables.get(i).getY() == (entity.getY() + 1)) {
						model.penetrables.remove(i);
					}
				}
				model.setElement(entity, pen, entity.getX() - 1, entity.getY(), entity.getX(), entity.getY());
				entity.setX(entity.getX() - 1);
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Thread t = new Thread(new Fall(entity, this.model));
				t.start();
				this.entity.setMoving(false);
			}
		}
	}

}
