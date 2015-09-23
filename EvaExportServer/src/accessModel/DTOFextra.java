package accessModel;

public class DTOFextra {
	
	private String kategorie;
	private int vehicle_no;
	private String bezeichnung;
	private long extraid;
	private String key;
	private String type;
	
	public DTOFextra(){}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public int getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(int vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public long getExtraid() {
		return extraid;
	}

	public void setExtraid(long l) {
		this.extraid = l;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DBFextra [kategorie=" + kategorie + ", vehicle_no="
				+ vehicle_no + ", bezeichnung=" + bezeichnung + ", extraid="
				+ extraid + ", key=" + key + ", type=" + type + "]";
	}
	
	
	
}
