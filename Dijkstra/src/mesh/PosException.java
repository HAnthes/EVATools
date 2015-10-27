package mesh;

public class PosException extends Exception {
	/**
	 * Fehlerklasse Position
	 */
	private static final long serialVersionUID = 1L;

	PosException(){
		super("Postionen muss positiv sein!");
	}

}