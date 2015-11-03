package mesh;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse f�r Punkt. Beschreibt einen Punkt eines Gitters Ein Punkt hat einen
 * Namen der nicht leer sein darf (kein "" oder null) wirft eine NameExecption
 * Ein Punkt hat eine Positions x,y die Ganzzahlig und positiv sein muss. wirft
 * eine PosExecption �ber getter lassen sich die Werte f�r Name und Position
 * ausgeben �ber seter l��t sich eine neue Position setzten.
 * 
 * @author anthes
 *
 */
public class Point {

	private String name;
	private int posX;
	private int posY;
	private List<Vektor> nachbarn = new ArrayList<Vektor>();

	public Point(String name, int posX, int posY) throws NameException,	PosException {
		if (name == null || name.equals("")) throw new NameException();
		if (posX < 0 || posY < 0)	throw new PosException();
		assert name != null && !name.equals("") : "Namen darf nicht leer oder null sein ";
		assert posX >= 0 && posY >= 0 : "Position muss positiv sein.";
		this.name = name;
		this.posX = posX;
		this.posY = posY;
	}

	public void addVerbindung(Vektor v) throws PointException {
		if(v.getPoint()==this || v.getPoint()==null || v==null) throw new PointException();
		if(ifPointExists(v)) throw new PointException();
		assert v.getPoint()!=this && v.getPoint()!=null && v!=null : "Vektor darf nicht auf sich selbst Zeigen oder null sein!";
		assert !ifPointExists(v) :"Vektor schon in der Liste";
		nachbarn.add(v);
	}
	
	public boolean removeVerbidung(Vektor vn){
	
		return nachbarn.remove(vn);
		
	}
	
	public String getName() {
		return name;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public List<Vektor> getNachbarn() {
		return nachbarn;
	}

	private boolean ifPointExists(Vektor vn){
		boolean temp=false;
		for(Vektor v : nachbarn){
			if(v==vn || v.getPoint() == vn.getPoint()) 
				{
				temp=true;
				break;
				}
		}
		return temp;
	}

}
