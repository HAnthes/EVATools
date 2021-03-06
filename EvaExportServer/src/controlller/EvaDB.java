package controlller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Vehicle;
import model.VehicleOptionCategory;

public class EvaDB {
	/**
	 * Auslesen der Daten aus der EVA Datebank
	 * Query reengierung aus EVA
	 * cars = Fahrzeuge inkl MM und Zubeh�r
	 * evoOptions EVA Zubeh�rverwaltungs Tabellen.
	 */
	private static java.util.logging.Logger jlogger  = java.util.logging.Logger.getLogger(Class.class.getName());
	private static List<Vehicle> cars;
	private static List<VehicleOptionCategory> evoOptions;
	public static void getVehicles() {
		
		jlogger.info("Datenverbindung zur EVA DB ge�ffnet");
		final String PU = "EVA_reader";
		EntityManagerFactory ef = Persistence.createEntityManagerFactory(PU);
		EntityManager em = ef.createEntityManager();

		String query = "SELECT l from Vehicle l where (((l.doPublishData)=1) AND ((l.vehSysType)=1) AND ((l.isused)=1) AND ((l.reserveState)is NULL) AND ((l.baseVehicleNo)is NULL) AND ((l.purdate)is NULL) OR ((l.doPublishData)=1) AND ((l.vehSysType)=1) AND ((l.isused)=1) AND ((l.reserveState)=0) AND ((l.baseVehicleNo)is NULL)  AND ((l.purdate)is NULL) OR ((l.doPublishData)=1) AND ((l.vehSysType)=1) AND ((l.isused)=1) AND ((l.reserveState)=1) AND ((l.baseVehicleNo)is NULL) AND ((l.purdate)is NULL)  )";

		TypedQuery<Vehicle> car = em.createQuery(query, model.Vehicle.class);

		cars = car.getResultList();
		
		TypedQuery<VehicleOptionCategory> evo = em.createNamedQuery("VehicleOptionCategory.findAll", model.VehicleOptionCategory.class);
		
		evoOptions =  evo.getResultList();
		
		em.close();
		ef.close();
		jlogger.info("Datenverbindung zur EVA geschlossen");
	}
	
	
	public static List<Vehicle> getCars() {
		return cars;
	}
	
	public static List<VehicleOptionCategory> getEvoOptions() {
		return evoOptions;
	}

	
}
