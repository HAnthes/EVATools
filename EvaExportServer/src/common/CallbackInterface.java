package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remotehook für Logausgabe
 * @author anthes
 *
 */
public interface CallbackInterface extends Remote{
	
	public void printer(String info) throws RemoteException;
	
}
