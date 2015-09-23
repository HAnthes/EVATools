package accessModel;
/**
 * POJO Bilderverwaltung
 * @author anthes
 *
 */
public class Pictures {
	private String evaName;
	
	public Pictures(String name){
		evaName = name;
	}
	
	public String getEvaName(){
		return evaName;
	}

	@Override
	public String toString() {
		return "Pictures [evaName=" + evaName + "]";
	}
	
	
}
