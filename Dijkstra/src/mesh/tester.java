package mesh;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Point p = new Point("Punkt 1", -100, 100);
		} catch (NameException | PosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
