package testGraph;

import static org.junit.Assert.*;
import graph.Verbindung;

import org.junit.Test;

public class TestVerbindung {

	/**
	 * Einfacher Test der Klasse Verbindung.
	 * liefern die Getter die richtigen Informationen.
	 */
	@Test
	public void test() {
		Object o = new Object();
		int i = 2;
		Verbindung<Object> v = new Verbindung<Object>(o,i);
		
		assertEquals(o, v.getData());
		assertEquals(i, v.getWeight());
	}

}
