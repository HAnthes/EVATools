package transfer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Vehicle;
import pictures.MakePictures;
import util.Setup;
import accessModel.DTOCar;
import accessModel.MakeAccess;
import controlller.EvaDB;
import csvModel.CSVAutoscout;
import csvModel.CSVMobile;
import csvModel.CSVUtil;
import csvModel.ICSVString;

public class Worker implements Runnable {
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Class.class.getName());
		
	private static boolean work = false;

	
	public Worker(){
		
	}
	
	public static synchronized boolean getWork() {
		return work;
	}

	private static synchronized void working() {
		work = true;
	}

	private static synchronized void notworking() {
		work = false;
	}

	public static void transfer() {
		
		working();
		try {
			jlogger.info("Server : Setup laden");
			
			Setup.makeSetup();

			jlogger.info("Server : EVA Daten laden");
			EvaDB.getVehicles();

			jlogger.info("Server : Bilder verarbeiten");
			MakePictures.makePics(EvaDB.getCars());

			jlogger.info("Server : Datenbank Exporte erzeugen");
			// POJO für die Exporte
			List<DTOCar> webCar = new ArrayList<DTOCar>();
			List<ICSVString> mobileCSV = new ArrayList<ICSVString>();
			List<ICSVString> autoscoutCSV = new ArrayList<ICSVString>();

			for (Vehicle auto : EvaDB.getCars()) {
				webCar.add(new DTOCar(auto));
				mobileCSV.add(new CSVMobile(auto));
				autoscoutCSV.add(new CSVAutoscout(auto));
			}
			jlogger.info("Server : Datenbank Exporte schreiben");
			CSVUtil.writeCSV(Setup.getCsv_mobile(), mobileCSV);
			CSVUtil.writeCSV(Setup.getCsv_As24(), autoscoutCSV);

			//nullen der CSV Tabellen
			jlogger.info("Server : CSV Daten null");
		
			
			MakeAccess.store(webCar);

			//Access DTO nullen
			jlogger.info("Server : JDBC Daten null");
		
			

			jlogger.info("Server : Transfer Start!");
			Transfer.submit(Setup.getTransfer());

			jlogger.info("Server : JPA Daten null");
			
		} catch (IOException e1) {
			System.out.println("Setup Datei nicht gefunden!" + e1);
		}
		jlogger.info("Beendet");
		notworking();
	}

	@Override
	public void run() {
		
		if(!getWork()) transfer();
		
	}
}
