package pictures;

import java.awt.Dimension;
import java.awt.Point;
/**
 * Info für die Bildeverarbeitung 
 * POJO für die Parameter aus den XML Dateien
 * @author anthes
 *
 */
public class PicBuildRule {

	private Point location;
	private Dimension dimension;

	public PicBuildRule(int x, int y, int h, int w) {
		location = new Point(x, y);
		dimension = new Dimension(h, w);
	}

	public Point getLocation() {
		return location;
	}

	public Dimension getDimension() {
		return dimension;
	}

	@Override
	public String toString() {
		return "PicBuildRule [location=" + location + ", dimension="
				+ dimension + "]";
	}
	
	
}
