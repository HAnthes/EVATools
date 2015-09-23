import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		// Berechnung der Zeitdifferenz
		executor.scheduleAtFixedRate(new Runnable()
		{
			@Override
			public void run()
			{
				
				
				cal.setTimeInMillis(System.currentTimeMillis());
				if(cal.get(Calendar.MINUTE) == 01){
					System.out.println(cal.get(Calendar.HOUR_OF_DAY));
					System.out.println(cal.get(Calendar.MINUTE));
				} else {
					System.out.println("...läuft" + cal.get(Calendar.HOUR_OF_DAY) +  "  "+cal.get(Calendar.MINUTE) );
				}
			}
		}, 5, 58, TimeUnit.SECONDS);
	}

}
