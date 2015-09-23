package common;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CallbackInterface extends Remote{
	public void printer(String info) throws RemoteException;
}
