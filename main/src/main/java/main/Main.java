/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import controller.Controller;

/**
 * The Class Main.
 *
 * @author Benjamin Brifault, Pierre Garrido, Bastien Aelters, Mattias Huros
 */
public abstract class 
Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final Controller controller = new Controller();
        controller.control();
    }
}
