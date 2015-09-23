package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import setup.Setup;
import common.CallbackInterface;
import common.WorkerInterface;


public class Client {

	private static WorkerInterface serverO=null;
	private static Clienimpl cbi = null;
	
	private static final class InstanceHolder{
		static final Client INSTANCE  = new Client();
	}

	private Client() {
		try {
			Setup.setup();
			Registry registry = LocateRegistry.getRegistry(Setup.getServer());
			serverO = (WorkerInterface)registry.lookup(Setup.getName());
			cbi = new Clienimpl();
			UnicastRemoteObject.exportObject(cbi, 0);
			serverO.registerCallback(cbi);

		} catch (Exception e) {

			System.out.println("Remote Fehler : " + e);
		}

	}
	
	public static Client getInstance(){
		return InstanceHolder.INSTANCE;
	}
	
	public CallbackInterface getCallBack(){
		return cbi;
	}
	
	public ObserverInterface getObserver(){
		return cbi;
	}
	
	public void deregister(){
		try {
			serverO.deregisterCallback(cbi);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Remote Fehler : " + e);
		}
	}
	
	public WorkerInterface getServer(){
		return serverO;
	}
}
