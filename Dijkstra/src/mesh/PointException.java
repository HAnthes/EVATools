package mesh;

public class PointException extends Exception {
 
	/**
	 * Fehlerklasse leerer oder null Naame
	 */
	private static final long serialVersionUID = 1L;

	PointException(){
		super("Punkt darf nicht mich sich selbst benachtbart sein oder Vektor mehrfach eingtragen sein!");
	}
	
  	
}
