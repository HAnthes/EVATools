package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import ticker.timerThread;
import util.RemoteWriter;
import util.ServerSetup;
/**
 * RMI Server mit Callbackhook.
 * 
 * <p>Main Klasse für den Server.
 * RemoteObjekt wird initialisiert, TickerThread erzeugt und Registiry gestartet.
 * Für die Verwendung auf Maschinen mit mehr als einem NIC muss noch per Parameter die Standart IP-Adresse einstellt werden
 * java Djava.rmi.server.hostname=Name oder Adresse
 * </p>
 *
 * @author anthes
 * @version 1
 * @since 16.09.2015
 * 
 * @todo Probleme mit dem Logger durch die Verwendung der UcanAccess Libary
 * {@link http://stackoverflow.com/questions/32206150/ucanaccess-logger}
 */

public class Server {
	
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Server.class.getName());
	
	public static void main(String[] args) {
			try{
				jlogger.info("Starte Server.");
		
				ServerSetup.makeSetup();
				ServerImplemtieung server = new ServerImplemtieung();
				RemoteWriter rw = RemoteWriter.getInstance();
				rw.setPrinter(server);
				timerThread.setTimerThread(ServerSetup.getStunde(), ServerSetup.getMinute(), server);
				UnicastRemoteObject.exportObject(server,0 );
				LocateRegistry.createRegistry(1099);
				Registry registry = LocateRegistry.getRegistry();
				registry.rebind(ServerSetup.getService(), server);
				jlogger.info("Server bereit v15.09.2015_09_36");
			} catch(Exception e)
			{ 
				jlogger.warning("Fehler beim starten des Servers : " + e  );
			}		
	}
}
