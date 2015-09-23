package pictures;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import util.RemoteWriter;
import util.ServerSetup;
import util.Setup;
import model.Vehicle;
import model.VehiclesMm;
/**
 * Klasse für die Bildverarbeitung.
 * Stellt Mehtoden zur Auswertung der XML Dateien und Threaderzeugung
 * 
 * @author anthes
 * Umstellung von "letzten Datum" auf FZG indiviuelles Datum und vorhandenseins Prüfung.
 */


public class MakePictures {
	
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(MakePictures.class.getName());
	private static  RemoteWriter rw = RemoteWriter.getInstance();	
	private static Properties pLoad = new Properties();
	private static Properties pSave = new Properties();
	
	/**
	 * Läd die Proptiesdatei, über pLoad verwendbar.
	 * @param fname
	 */
	private static void loadProperties(String fname){
		try {
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream(fname));
			jlogger.info("Car.Propiertes geladen " + fname);
			pLoad.load(stream);
			stream.close();
		} catch (Exception e) {
			jlogger.warning("Fehler beim lesen der Car.Properties"  + e);
		}
	}
	
	/**
	 * Speichert die Propertiesdatei pSave
	 * @param fname
	 */
	private static void saveProperites(String fname){
		try {
			FileOutputStream out = new FileOutputStream(fname);
			jlogger.info("Car.Propiertes geschrieben " + fname);
			pSave.store(out,"-Autoupdate-");
			out.close();
		} catch (Exception e) {
			jlogger.warning("Fehler beim schreibe der Car.Properties"  + e);
		}
	}
	
	/**
	 * Sucht das "größte" neueste Datum in einem Bilderset für ein FZG.
	 * Ohne Bilder lieftert 0
	 * @param car
	 * @return
	 */
	private static Long getLastDate(Vehicle car){
		Long temp =0l;
		for (VehiclesMm mm : car.getVehiclesMms()) {
			File x = new File(Setup.geteVAPic() + "/" + mm.getFilename());
			if(x.lastModified()>temp) temp=x.lastModified();
		}
		return temp;
	}

	/**
	 * Prüft ob Bildersets bearbeitet werden müssen
	 * Ist FZG nicht in pLoad
	 * 		Daten ermitteln und in pSave stellen
	 * Ist in pLoad 
	 * 		Daten prüfen und in pSave updaten
	 * pSave hält so alle aktuellen Daten der FZG DB
	 * 
	 * @param car
	 * @return
	 */
	private static boolean checkPic(Vehicle car){
		//ist FZG unter den Properites?
		if(pLoad.getProperty(car.getVehicleNo().toString())==null){
			jlogger.info("Fahrzeug neu : " + car.getVehicleNo());
			pSave.setProperty(car.getVehicleNo().toString(), getLastDate(car).toString());
			jlogger.info("Fahrzeug neu : " + car.getVehicleNo()  );
			return true;
		} else {
			//Ist schon vorhanden - ist ein Bilder neuer?
			Long pDate = Long.parseLong(pLoad.getProperty(car.getVehicleNo().toString()));
			Long isDate = getLastDate(car);
			pSave.setProperty(car.getVehicleNo().toString(), isDate.toString());
			if (pDate.compareTo(isDate)!=0){
				jlogger.info("Fahrzeug vorhanden Bilder neu : " + car.getVehicleNo() + "   -  " + pDate + "   -   " + isDate  );
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Erzeugt den Threadpool für die PictureWorkerthreads
	 * Für jedes Verarbeitungs XML PicBuildRuleSets ein Pool / Thread.
	 * Thread Pool über ServerConfig einstellbar.
	 * 
	 * @param cars
	 */
	public static void makePics(List<Vehicle> cars) {
		
		//Holden der Properties
		loadProperties(Setup.getPichistorie());
		
		List<PicBuildRuleSet> rulesets = pictures.XMLReader.getXML(Setup.getpicxml());
		List<ArrayBlockingQueue<Vehicle>> pipes  = new ArrayList<ArrayBlockingQueue<Vehicle>>();

		CountDownLatch sync = new CountDownLatch(rulesets.size());
		
		//Über Serversetup Thread begrenzbar
		ExecutorService pool;
		if (ServerSetup.getThreads()==0) {
		pool = Executors.newCachedThreadPool();
		} else {
			pool = Executors.newFixedThreadPool(ServerSetup.getThreads());
		}
		
		//Pipes für alle XML Dateien
		for(PicBuildRuleSet bs : rulesets){
			ArrayBlockingQueue<Vehicle> pipe = new ArrayBlockingQueue<Vehicle>(50);
			pipes.add(pipe);
			PictureWorker worker = new PictureWorker(bs, pipe,sync);
			pool.submit(worker);
		}

		for (Vehicle a : cars) {
			try {
				if (checkPic(a)) {
					for(ArrayBlockingQueue<Vehicle> pipe : pipes){
						pipe.put(a);
						jlogger.info("In Warteschlage :" +a.getOrderNo());
						rw.print("Bilderverbeitung  -> In Warteschalgen : " + a.getModelText() + " : " +a.getOrderNo());
					}
				}
			} catch (InterruptedException e) {
				jlogger.warning("Thread - Queues Interrupted  : " + e);
			}
		}
		//Schreiben  der Props
		saveProperites(Setup.getPichistorie());
		pool.shutdown();
		try {
			sync.await();
		} catch (InterruptedException e) {
			jlogger.warning("Thread - Sync Interrupted  : " + e);
		}
		jlogger.info("Bildebearbeitung syncpunkt erreicht");
		rw.print("Bilderverbeitung : alle Threads beendet.");
		
	}
	
}