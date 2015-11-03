package mesh;
/**
 * Ein Vektor verbindet genau zwei Punkte
 * Vom Punkt nach p und ist somit gerichtet
 * Ein Vektor hat ein bestimmtes Gewischt, ganzzahlig >0 nicht negativ.
 * 
 * über getter lassen sich die Punkte ermitteln. 
 * @author anthes
 *
 */
public class Vektor {
	
	private Point p;
	private int weight;
	
	public Vektor(Point p, int weight){
		this.p = p;
		this.weight = weight;
	}
	public Point getPoint(){
		return p;
	}
	
}
