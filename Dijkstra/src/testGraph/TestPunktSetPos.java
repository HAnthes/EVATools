package testGraph;

import static org.junit.Assert.*;
import graph.Punkt;
import graph.PunktException;

import org.junit.Test;

public class TestPunktSetPos {

	/**
	 * Test der Methoden setX setY
	 */
	
	@Test
	public void MethodeSetPosXPositiv() {
		String name = "Name";
		int x = 12;
		int y = 14;
		int newX = 15;
		try {
			Punkt p = new Punkt(name,x,y);
			p.setPosX(newX);
			assertTrue(p.getPosX() == newX);
		} catch (PunktException e) {
			fail("Problem bei der Instanzerung");
		}
	}
	
	@Test
	public void MethodeSetPosYPositiv() {
		String name = "Name";
		int x = 12;
		int y = 14;
		int newY = 15;
		try {
			Punkt p = new Punkt(name,x,y);
			p.setPosY(newY);
			assertTrue(p.getPosY() == newY);
		} catch (PunktException e) {
			fail("Problem bei der Instanzerung");
		}
	}

	/**
	 * Testen auf Ausnahme
	 */
	
	@Test (expected=PunktException.class)
	public void MethodeSetPosXException() throws PunktException {
		String name = "Name";
		int x = 12;
		int y = 14;
		int newX = 0;
		Punkt p=null;
		try {
			p = new Punkt(name,x,y);
		} catch (PunktException e) {
			fail("Problem bei der Instanzerung");
		}	
		p.setPosX(newX);
	}
	

	@Test (expected=PunktException.class)
	public void MethodeSetPosYException() throws PunktException {
		String name = "Name";
		int x = 12;
		int y = 14;
		int newY = 0;
		Punkt p=null;
		try {
			p = new Punkt(name,x,y);
		} catch (PunktException e) {
			fail("Problem bei der Instanzerung");
		}	
		p.setPosY(newY);
	}

}
