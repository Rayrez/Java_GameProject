package contract;

/**
 * The Interface IController.
 *
 * @author Mattias Huros
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param caracter
	 *          the controller order
	 */
	public void giveKey(char caracter);
}
