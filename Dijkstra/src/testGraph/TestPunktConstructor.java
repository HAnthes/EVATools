package testGraph;

import static org.junit.Assert.*;

import graph.Punkt;
import graph.PunktException;
import org.junit.Test;

public class TestPunktConstructor  {

	
	/**
	 * Tests auf korrekte Funktion Instanzieren
	 */
	@Test
	public void ErzeugenGetName() {
		try {
			String name = "Name";
			int x = 12;
			int y = 14;
			Punkt p = new Punkt(name,x,y);
			assertEquals(p.getName(), name);
		} catch (PunktException e) {
			fail("Fehler");
	 }
	}
	
	
	@Test
	public void ErzeugenGetPosX() {
		
		try {
			String name = "Name";
			int x = 12;
			int y = 14;
			Punkt p = new Punkt(name,x,y);
			assertTrue(p.getPosX() == x);
		} catch (PunktException e) {
			fail("Fehler");
	 }
		
	}

	@Test
	public void ErzeugenGetPosY() {
		try {
			String name = "Name";
			int x = 12;
			int y = 14;
			Punkt p = new Punkt(name,x,y);
			assertTrue(p.getPosY() == y);
		} catch (PunktException e) {
			fail("Fehler");
	 }
	}
	
	/**
	 * Auf erwartete Ausnahmanen hin prüfen
	 * Name null oder "", PosX oder PosY oder beide !>0
	 */
	
	@Test (expected=PunktException.class)
	public void ErzeugenExceptionNameEmpty() throws Exception{
		String name = "";
		int x = 12;
		int y = 14;
		Punkt p = new Punkt(name,x,y);
		assertNull(p);
	}
	
	@Test (expected=PunktException.class)
	public void ErzeugenExceptionNameNull() throws Exception{
		String name = null;
		int x = 12;
		int y = 14;
		Punkt p = new Punkt(name,x,y);
		assertNull(p);
	}
	
	@Test (expected=PunktException.class)
	public void ErzeugenExceptionPosXZero() throws Exception{
		String name = "Name";
		int x = 0;
		int y = 14;
		Punkt p = new Punkt(name,x,y);
		assertNull(p);
	}
	
	@Test (expected=PunktException.class)
	public void ErzeugenExceptionPosXlessZero() throws Exception{
		String name = "Name";
		int x = -10;
		int y = 14;
		Punkt p = new Punkt(name,x,y);
		assertNull(p);
	}
	
	@Test (expected=PunktException.class)
	public void ErzeugenExceptionPosYZero() throws Exception{
		String name = "Name";
		int x = 10;
		int y = 0;
		Punkt p = new Punkt(name,x,y);
		assertNull(p);
	}
	
	@Test (expected=PunktException.class)
	public void ErzeugenExceptionPosYlessZero() throws Exception{
		String name = "Name";
		int x = 10;
		int y = -14;
		Punkt p = new Punkt(name,x,y);
		assertNull(p);
	}

}
