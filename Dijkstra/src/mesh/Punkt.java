package mesh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Punkt implements InterfacePunkt {

	private String name;
	private int posX;
	private int posY;
	private final int thresbold = 0; 
	private List<Verbindung<InterfacePunkt>> nachbarn = new ArrayList<Verbindung<InterfacePunkt>>();
	
	public Punkt(String name, int posX, int posY) throws PunktException{
		
		if (name == null || name.equals("")) throw new PunktException();
		if (!(posX > thresbold) || !(posY > thresbold))	throw new PunktException();
		
		this.name = name;
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public int getPosY() {
		return posY;
	}

	@Override
	public void setPosX(int newX) throws PunktException {
		if (!(newX > thresbold) ) throw new PunktException();
		assert posX > thresbold  : "Position muss positiv sein.";
		this.posX=newX;
	}

	@Override
	public void setPosY(int newY) throws PunktException {
		if (!(newY > thresbold) ) throw new PunktException();
		assert posY > thresbold  : "Position muss positiv sein.";
		this.posY=newY;
	}

	@Override
	public void addVerbindung(Verbindung<InterfacePunkt> verbindung)
			throws VerbindungsException {
		if(verbindung.getData()==null || nachbarn.contains(verbindung) || verbindung.getData() == this) throw new VerbindungsException();
		
		for(Verbindung<InterfacePunkt> i : nachbarn){
			if (i.getData() == verbindung.getData()) throw new VerbindungsException();
		}
		nachbarn.add(verbindung);
	}

	@Override
	public void removeVerbindung(Verbindung<InterfacePunkt> verbindung)
			throws VerbindungsException {
		if (!nachbarn.remove(verbindung)) throw new VerbindungsException();

	}

	@Override
	public Collection<Verbindung<InterfacePunkt>> getNachbarn() {

		return nachbarn;
	}

}
