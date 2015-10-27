package mesh;


/**
 * Klasse f�r Punkt.
 * Beschreibt einen Punkt eines Gitters
 * Ein Punkt hat einen Namen der nicht leer sein darf (kein "" oder null) wirft eine NameExecption
 * Ein Punkt hat eine Positions x,y die Ganzzahlig und positiv sein muss. wirft eine PosExecption
 * �ber getter lassen sich die Werte f�r Name und Position ausgeben
 * �ber seter l��t sich eine neue Position setzten.
 * @author anthes
 *
 */
public class Point {

	private String name;
	private int posX;
	private int posY;
	
	public Point(String name, int posX, int posY) throws NameException, PosException{
		
		
		if (name != null && !name.equals("")) throw new NameException();
		if (posX >=0 && posY>=0) throw new PosException();
		assert name != null && !name.equals("") : "Namen darf nicht leer oder null sein";
		assert posX >=0 && posY>=0 :"Position muss positiv sein.";
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		
	}
}