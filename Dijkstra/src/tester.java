import mesh.NameException;
import mesh.Point;
import mesh.PointException;
import mesh.PosException;
import mesh.Vektor;



public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Point p1 = new Point("Punkt 1", 100, 100);
			Point p2 = new Point("Punkt 2",20,30);
			Vektor v = new  Vektor(p2, 7);
			p1.addVerbindung(v);
			p1.addVerbindung(new Vektor(new Point("Punkt 3", 8, 7),2));
			System.out.println(p1.getNachbarn().size());
			p1.removeVerbidung(v);
			System.out.println(p1.getNachbarn().size());
			p1.addVerbindung(v);
			System.out.println(p1.getNachbarn().size());
		} catch (NameException | PosException | PointException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}