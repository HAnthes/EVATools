package mesh_TestSuite;

import static org.junit.Assert.*;
import mesh.InterfacePunkt;
import mesh.Punkt;
import mesh.Verbindung;
import mesh.VerbindungsException;

import org.junit.Before;
import org.junit.Test;

public class Punkt_TestNachbarschaft {
	
	private Punkt a;
	private Punkt b;
	private Punkt c;
	private Punkt d;
	
	@Before
	public void setUp() throws Exception {
		/**
		 * Punkte vorbereiten
		 */
		a = new Punkt("Punkt A", 12, 10);
		b = new Punkt("Punkt B", 11, 10);
		c = new Punkt("Punkt C", 13, 10);
		d = new Punkt("Punkt D", 14, 10);
		
	}


	@Test
	public void testAddVerbindungPositiv() throws VerbindungsException {
		
		Verbindung<InterfacePunkt> v1 = new Verbindung<InterfacePunkt>(b,19);
		Verbindung<InterfacePunkt> v2 = new Verbindung<InterfacePunkt>(c,19);
		a.addVerbindung(v1);
		a.addVerbindung(v2);
		assertTrue(a.getNachbarn().size()==2 && a.getNachbarn().contains(v1) && a.getNachbarn().contains(v2));
	
	}
	
	@Test (expected=VerbindungsException.class)
	public void testAddVerbindungNegativNull() throws VerbindungsException {
		Verbindung<InterfacePunkt> v1 = new Verbindung<InterfacePunkt>(b,19);
		Verbindung<InterfacePunkt> v2 = new Verbindung<InterfacePunkt>(null,19);
		a.addVerbindung(v1);
		a.addVerbindung(v2);
		assertTrue(a.getNachbarn().size()==1 && a.getNachbarn().contains(v1));
	}

	@Test (expected=VerbindungsException.class)
	public void testAddVerbindungNegativDoppelt() throws VerbindungsException {
		Verbindung<InterfacePunkt> v1 = new Verbindung<InterfacePunkt>(b,19);
		Verbindung<InterfacePunkt> v2 = new Verbindung<InterfacePunkt>(c,19);
		a.addVerbindung(v1);
		a.addVerbindung(v2);
		a.addVerbindung(v2);
		assertTrue(a.getNachbarn().size()==2 && a.getNachbarn().contains(v1) && a.getNachbarn().contains(v2));
	}
	
	@Test (expected=VerbindungsException.class)
	public void testAddVerbindungNegativSelbst() throws VerbindungsException {
		Verbindung<InterfacePunkt> v1 = new Verbindung<InterfacePunkt>(b,19);
		Verbindung<InterfacePunkt> v2 = new Verbindung<InterfacePunkt>(a,19);
		a.addVerbindung(v1);
		a.addVerbindung(v2);
		assertTrue(a.getNachbarn().size()==1 && a.getNachbarn().contains(v1));
	}
	
	@Test
	public void testRemoveVerbindungPositiv() throws VerbindungsException {
		Verbindung<InterfacePunkt> v1 = new Verbindung<InterfacePunkt>(b,19);
		Verbindung<InterfacePunkt> v2 = new Verbindung<InterfacePunkt>(c,19);
		Verbindung<InterfacePunkt> v3 = new Verbindung<InterfacePunkt>(d,29);
	
		a.addVerbindung(v1);
		a.addVerbindung(v2);
		a.addVerbindung(v3);
		
		assertTrue(a.getNachbarn().size()==3 && a.getNachbarn().contains(v1) && a.getNachbarn().contains(v2) && a.getNachbarn().contains(v3));
		
		a.removeVerbindung(v2);
		assertTrue(a.getNachbarn().size()==2 && a.getNachbarn().contains(v1) && a.getNachbarn().contains(v3));
	}

	@Test (expected=VerbindungsException.class)
	public void testRemoveVerbindungNegativ() throws VerbindungsException {
		Verbindung<InterfacePunkt> v1 = new Verbindung<InterfacePunkt>(b,19);
		Verbindung<InterfacePunkt> v2 = new Verbindung<InterfacePunkt>(c,19);
		Verbindung<InterfacePunkt> v3 = new Verbindung<InterfacePunkt>(d,29);
	
		a.addVerbindung(v1);
		a.addVerbindung(v2);
		
		assertTrue(a.getNachbarn().size()==2 && a.getNachbarn().contains(v1) && a.getNachbarn().contains(v2));
		
		a.removeVerbindung(v3);
		assertTrue(a.getNachbarn().size()==2 && a.getNachbarn().contains(v1) && a.getNachbarn().contains(v3));
	}
	
	@Test
	public void testGetNachbarn() throws VerbindungsException {
		Verbindung<InterfacePunkt> v1 = new Verbindung<InterfacePunkt>(b,19);
		Verbindung<InterfacePunkt> v2 = new Verbindung<InterfacePunkt>(c,19);
		Verbindung<InterfacePunkt> v3 = new Verbindung<InterfacePunkt>(d,29);
	
		a.addVerbindung(v1);
		a.addVerbindung(v2);
		a.addVerbindung(v3);
		
		assertTrue(a.getNachbarn().size()==3 && a.getNachbarn().contains(v1) && a.getNachbarn().contains(v2) && a.getNachbarn().contains(v3));
	}

}
