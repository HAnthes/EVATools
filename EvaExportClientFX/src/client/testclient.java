package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.CallbackInterface;
import common.WorkerInterface;

public class testclient {
/**
 * Start : prüfen ob Aktion läuft Startbuttom ausgrauen
 * Listener Registieren
 * Aktions Listener fehlt noch?!
 * Warten
 * 
 * @param args
 */
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry();
			WorkerInterface serverO = (WorkerInterface)registry.lookup("exportserver");
			CallbackInterface cbi = new Clienimpl();
			UnicastRemoteObject.exportObject(cbi, 0);
			serverO.registerCallback(cbi);
			serverO.startTransfer();
			serverO.getStatus();
			
		} catch (Exception e) {

			System.out.println(e);
		}
	}

}
