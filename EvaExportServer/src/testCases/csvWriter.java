package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;





import model.Vehicle;
import accessModel.DTOCar;
import accessModel.MakeAccess;
import controlller.EvaDB;
import csvModel.CSVAutoscout;
import csvModel.CSVMobile;
import csvModel.CSVUtil;
import csvModel.ICSVString;
import util.Setup;

public class csvWriter {
	static Logger logger = Logger.getLogger(csvWriter.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Setup.makeSetup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EvaDB.getVehicles();
		List<DTOCar> webCar = new ArrayList<DTOCar>();
		List<ICSVString> mobileCSV = new ArrayList<ICSVString>();
		List<ICSVString> autoscoutCSV = new ArrayList<ICSVString>();

		
		System.out.println(logger.getHandlers().length);
		
	
		for (Vehicle auto : EvaDB.getCars()) {
			webCar.add(new DTOCar(auto));
			mobileCSV.add(new CSVMobile(auto));
			autoscoutCSV.add(new CSVAutoscout(auto));
		}
		
		CSVUtil.writeCSV(Setup.getCsv_mobile(), mobileCSV);
		CSVUtil.writeCSV(Setup.getCsv_As24(), autoscoutCSV);
		logger.setLevel(Level.ALL);
		System.out.println(logger.getHandlers().length);
		MakeAccess.store(webCar);
		System.out.println(logger.getHandlers().length);
		logger.addHandler(new ConsoleHandler());
		logger.info("Sau");

	}

}
