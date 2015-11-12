package csvModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
/**
 * Schreibt Zeile für Zeile POJO's als CSV Datei.
 * @author anthes
 *
 */
public class CSVUtil {

	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Class.class.getName());
	
	public static void writeCSV(String dateiname, Collection<ICSVString> daten ){
			
		jlogger.info("CSV schrebien");
		File datei=null;
			FileWriter writer;
		     try  {
		    	 jlogger.info(dateiname);
		    	 datei = new File(dateiname);
		    	 writer = new FileWriter(datei);
		    	 for (ICSVString s : daten){
		    		writer.write(s.getCSV());
		    	 	writer.write(System.getProperty("line.separator"));
		    	 }
		       writer.flush();
		       writer.close();
		    } catch (IOException e) {
		      jlogger.warning("Fehler beim schreiben der CSV Datei :" + dateiname +  " :  " + e);
		    }
		  }
	}
	

