package model;

import entity.movable.Movable;

public class Fall implements Runnable {

	private Movable entity;
	private final Model model;
	
	public Fall(Movable e, Model m) {
		this.entity = e;
		this.model = m;
	}
	
	@Override
	public void run() {
		int initial_x, initial_y;
		System.out.println("Fall");
		
		//if(map[entity.getX()][entity.getY()])
	}

}
