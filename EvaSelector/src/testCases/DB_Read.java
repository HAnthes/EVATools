package testCases;

import java.util.List;

import controller.EvaDB;
import model.Vehicle;

public class DB_Read {
	public static void main(String[] args){
		
		List<Vehicle> cars = EvaDB.getCars();
		
		for(Vehicle car : cars){
			System.out.println(car);
		}
		
		
	}
}
