package mesh;

public class NameException extends Exception {
 
	/**
	 * Fehlerklasse leerer oder null Naame
	 */
	private static final long serialVersionUID = 1L;

	NameException(){
		super("Name darf nicht leer oder null sein!");
	}
	
  	
}
