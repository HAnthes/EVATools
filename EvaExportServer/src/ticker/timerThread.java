package ticker;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import common.WorkerInterface;

public class timerThread  {
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Class.class.getName());
	private static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	private static GregorianCalendar cal = new GregorianCalendar();
	
	public static void setTimerThread(int stunde, int minute, WorkerInterface wi){
		cal.setTimeInMillis(System.currentTimeMillis());
		executor.scheduleAtFixedRate(new Runnable()
		{
			@Override
			public void run()
			{
				cal.setTimeInMillis(System.currentTimeMillis());
				//System.out.println("Ticker: " + cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " +stunde +":"+minute);
				if(cal.get(Calendar.MINUTE) == minute && cal.get(Calendar.HOUR_OF_DAY)==stunde){
					jlogger.info("Timerstart: " + cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) );
					try {
						if (!wi.getStatus()){
							jlogger.info("Timer : Worker gestartet");
							wi.startTransfer();
						}
					} catch (RemoteException e) {
					jlogger.warning("Probleme beim Timerthead : " + e);
					}
				}
			}
		}, 5, 59, TimeUnit.SECONDS);
		
	}

}
