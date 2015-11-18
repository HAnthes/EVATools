package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Vehicle;

public class EvaDB {

	/**
	 * Lesen der Daten aus der EVA DB 
	 * @author anthes
	 * @version 0.1
	 */
	
	private static List<Vehicle> cars;
	/**
	 * query nach etwas forschen. 
	 */
	private static void getVehicles() {
		
		final String PU = "EVA_reader";
		EntityManagerFactory ef = Persistence.createEntityManagerFactory(PU);
		EntityManager em = ef.createEntityManager();

		String query = "SELECT l from Vehicle l where (((l.vehSysType)=1)) ORDER BY l.dateCreated DESC";

		TypedQuery<Vehicle> car = em.createQuery(query, model.Vehicle.class);

		cars = car.getResultList();
		em.close();
		ef.close();
	}
	
	
	public static List<Vehicle> getCars() {
		getVehicles();
		return cars;
	}
}
