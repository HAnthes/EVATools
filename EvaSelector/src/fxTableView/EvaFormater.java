package fxTableView;

import model.Vehicle;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
/**
 * Controller für Textviewausgabe
 * @author anthes
 * Test!
 *
 */
public class EvaFormater {
	
	private TextArea view;
	private Vehicle car;
	private int size=1;
	
	public EvaFormater(TextArea view, int size){
		this.view = view;
		this.size = size;
	}
	
	private void settext(){
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				view.clear();
				view.appendText(ToStringVehicle.getstr(car, size));
			}
		});
	
	}
	
	public void setSize(int x){
		size=x;
		settext();
	}
	
	
	public void setCar(Vehicle car){
		this.car = car;
		settext();
	}
}
