package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface WorkerInterface extends Remote{
	
	public Collection<String> getSetup() throws RemoteException;
	
	public boolean getStatus() throws RemoteException;
	
	public void startTransfer() throws RemoteException;
	
	public long getLastTransfer() throws RemoteException;
	
	public void setLastTransfer(long daysback) throws RemoteException;
		
	public void registerCallback(CallbackInterface cbi) throws RemoteException;
	
	public void deregisterCallback(CallbackInterface cbi) throws RemoteException;
	
}
