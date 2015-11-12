package server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import transfer.Worker;
import util.Setup;
import common.CallbackInterface;
import common.WorkerInterface;
/**
 * Server Implementierung für den RMI Stub.
 * @author anthes
 *
 */

public class ServerImplemtieung implements WorkerInterface, PrinterInterface{
	
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Class.class.getName());
	
	private List<CallbackInterface>listener = new ArrayList<CallbackInterface>();
	
	@Override
	//TODO : Übergabe von SEtupinfos aufteilen!
	public Collection<String> getSetup() throws RemoteException {
		ArrayList<String> setup = new ArrayList<String>();
		setup.add("Access DB :" + Setup.getAccessWork());
		setup.add("EVA Bin   : "+ Setup.geteVAPic());		
		return setup;
	}

	
	@Override
	public boolean getStatus() throws RemoteException {
		print("Status:" +  Worker.getWork());
		return Worker.getWork();
	}

	@Override
	public void startTransfer() throws RemoteException {
		print("Starte :");
		jlogger.info("Versuche Tranfsfer zu stsrten");
		if(!Worker.getWork()){
			jlogger.info("Starte Transfgerthread");
			Thread worker = new Thread(new Worker());
			worker.start();
		} else
		{
			jlogger.info("Transferthread läuft bereits");
			print("Übertragung ist bereits aktiv");
			
		}
		jlogger.info("Transferthread beendet oder nicht gestartet");
		print("Übertragung abgschlossen");
	}


	@Override
	public synchronized void registerCallback(CallbackInterface cbi) throws RemoteException {
		jlogger.info("Registere Callbacklistener");
		listener.add(cbi);
		
	}

	@Override
	public synchronized void deregisterCallback(CallbackInterface cbi)
			throws RemoteException {
		jlogger.info("lösche Callbacklistener");
		listener.remove(cbi);
		
	}

	
	public synchronized void print(String text){
	//	System.out.println("Listener Registiert =  " + listener.size());
		for(CallbackInterface i : listener){
			try{
				//System.out.println("Start Ausgabe");
				i.printer(text);
			} catch (RemoteException e){
				listener.remove(i);
				jlogger.warning("Callback Fehler : löschen " + listener.size() + "Fehler  :" +   e );
			}
		}
	}

	@Override
	public long getLastTransfer() throws RemoteException {
		long help=0;
		try {
			help= Setup.getLastExport();
		} catch (IOException e) {
			jlogger.warning("Fehler beim Abfragen der letzten Übertragung: " +  e);
		}
		return help;
	}

	@Override
	public void setLastTransfer(long datumlong) throws RemoteException {
		
		try {
			Setup.setLastExport(datumlong);
		} catch (IOException e) {
			jlogger.warning("Fehler beim setzen einens neuen Übtragungsdatums : " +  e);
		}
	}
	
}
