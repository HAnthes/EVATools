package accessModel;


/**
 * POJO Kategorie
 * 
 * @author anthes
 *
 */
public class DTOextraCat {

	private long extraid;
	private String cat;

	public DTOextraCat(long l, String cat) {
		this.extraid = l;
		this.cat = cat;
	}

	public long getExtraid() {
		return extraid;
	}

	public void setExtraid(long extraid) {
		this.extraid = extraid;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "DBextraCat [extraid=" + extraid + ", cat=" + cat + "]";
	}
	
	
	
}
