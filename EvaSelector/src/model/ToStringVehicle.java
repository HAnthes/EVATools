package model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class ToStringVehicle {

	public static String getstr(Vehicle m){
		String temp = "";
		
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
		int max = 45;
		int c=0;
		for (Fextra x : m.getFextras()) {
			c+=x.getDescr().length();
			temp +=x.getDescr() + ", ";
			if(c>=max){
				temp+="\n";
				c=0;
			}
		}
		
		return temp;
		
	}
	
}
