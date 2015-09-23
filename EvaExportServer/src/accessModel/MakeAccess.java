package accessModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import util.RemoteWriter;
import util.Setup;
import controlller.EvaDB;
/**
 * Controllerklasse für das Einfügung in Access DB - UCanAccess
 * @author anthes
 *
 */
public class MakeAccess {
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(MakeAccess.class.getName());
	
	private static RemoteWriter rw = RemoteWriter.getInstance();
	
	public static void store(List<DTOCar> webCar){
		jlogger.info("Lade Ucanaccersstreiber");
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			jlogger.warning("Fehler beim laden des Treibers : " + e);
		}
		jlogger.info("DB verbinden");
		try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://"+Setup.getAccessWork())) {
			Setup.makeAccess();
			rw.print("UCanAccess : Datenbank Access Schreiben");
			DBCar.insert(conn, webCar);
			DBevo_Category.insert(conn, EvaDB.getEvoOptions());
			} catch (Exception e) {
				jlogger.warning("Fehler beim DB verbringen : " +e );
	} 

	}
}
