package model;

import entity.movable.Movable;

public class Fall implements Runnable {

	private Movable entity;
	
	public Fall(Movable e) {
		this.entity = e;
	}
	
	@Override
	public void run() {
		System.out.print("Je tombe !!!");
		entity.isMortal();
	}

}
