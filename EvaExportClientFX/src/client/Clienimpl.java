package client;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import common.CallbackInterface;

public class Clienimpl implements CallbackInterface, ObserverInterface {

	List<RemoteListener> listener = new ArrayList<RemoteListener>();

	@Override
	public void printer(String info) throws RemoteException {
		for (RemoteListener i : listener) {
			i.rlistner(info);
		}
		}
	
	@Override
	public void register(RemoteListener rl) {
		
		listener.add(rl);
	}
}
