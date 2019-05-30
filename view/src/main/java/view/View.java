package view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import contract.*;

import entity.Entity;


/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View extends JFrame implements IView, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3729391891433730765L;
	private final IModel model;
	private Components components;

	public View(IModel modelP) {
		this.model = modelP;
		this.components = new Components(modelP);
		this.setContentPane(this.components);
		this.setTitle("Boulder Dash");
		this.setSize(407, 510);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JButton("Pause"), BorderLayout.SOUTH);
		this.model.getObservable().addObserver(this.components);
		this.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
	}

}
