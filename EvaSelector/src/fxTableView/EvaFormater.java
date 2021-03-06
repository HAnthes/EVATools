package fxTableView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import model.Fextra;
import model.Vehicle;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
/**
 * Controller f�r Textviewausgabe Spaltenbreite ist ver�nderbar
 * @author anthes
 * @version 0.1
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
				view.appendText(getstr(car, size));
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

	/**
	 * Passt die Spalten an, mehr Idee als real
	 * @param Fahrzeug Pojo
	 * @param Int Wert f�r die etwas Spaltenbreite
	 * @return String einsprechend formatiert
	 * Ein Spaltenbreite von 1 cuttet den Kopf.
	 */
	
	private String getstr(Vehicle m, int size){
		if(m==null) return "Kein Auto gew�hlt.";
		String temp = "";
		if(size>1){
		temp += "GW-Nr. : "+ m.getOrderNo() + "-" +m.getVehicleNo() +"\n \n";
		temp += m.getText1() + " " + m.getText2() + " " + m.getDesignDesc() + "\n \n";
		SimpleDateFormat formatter = new SimpleDateFormat("MM.yyyy");
		temp += "EZ.: " + formatter.format(m.getRegdate()) + ", " + m.getSpeedoKm() + "km, " + m.getPower() +"kW,  " + m.getCapacity() + "cm� \n \n";
		
		temp+= m.getAuto().equals(new BigDecimal(0))?"Schaltgetriebe, ":"Automatik, ";
		
		if (m.getAllwheel().equals(new BigDecimal(1))) temp+="Allrad, ";
		if (m.getAllwheel().equals(new BigDecimal(2))) temp+="Frontantrieb, ";
		if (m.getAllwheel().equals(new BigDecimal(3))) temp+="Heckantrieb, ";
		temp += "HU/AU :"+ m.getMainCheck();
	
		temp +="\n \nAusstattung : \n";
		}
		int c=0;
		for (Fextra x : m.getFextras()) {
			c+=x.getDescr().length();
			temp +=x.getDescr() + ", ";
			if(c>=size){
				temp+="\n";
				c=0;
			}
		}
		
		return temp;
		
	}


}
