package graph;

import java.util.Collection;

public interface InterfacePunkt {

	public String getName();
	public int getPosX();
	public int getPosY();
	
	public void setPosX(int newX) throws PunktException;
	public void setPosY(int newY) throws PunktException;
	
	public void addVerbindung(Verbindung<InterfacePunkt> verbindung) throws VerbindungsException; 
	public void removeVerbindung(Verbindung<InterfacePunkt> verbindung) throws VerbindungsException;
	
	public Collection<Verbindung<InterfacePunkt>> getNachbarn();
	
	
}
