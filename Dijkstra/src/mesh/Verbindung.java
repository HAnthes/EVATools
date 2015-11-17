package mesh;
/**
 * @author anthes
 *	
 */
public class Verbindung<T> {
	
	private T data;
	private int weight;
	
	public Verbindung(T data, int weight){
		this.data = data;
		this.weight = weight;
	}
	public T getData(){
		return data;
	}
	
	public int getWeight(){
		return weight;
	}
}
