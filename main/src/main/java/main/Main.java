/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import controller.Controller;

/**
 * The Class Main.
 *
 * @author Benjamin BRIFAULT, Pierre GARRIDO, Bastien AELTERS, Mattias HUROT
 */
public abstract class 
Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments.
     */
    public static void main(final String[] args) {
        final Controller controller = new Controller();
        controller.control();
    }
}
