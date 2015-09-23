package transfer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Parameter für die einzelen Datenübertragzngne zusammenstellen.
 * 
 * Zusammenpacken falls nötig
 * Übertragen - ZIP oder Dateien
 * Löschen wenn yes
 * 
 * @author anthes
 *
 */
public class ReadExportSetup {
	
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(ReadExportSetup.class.getName()); 

		public static List<TransferSetup> read (String dir){
			List<TransferSetup> tansfersetup = new ArrayList<TransferSetup>();
			File f = new File(dir); // current directory
			    File[] files = f.listFiles();
			    for (File file : files) {
			        if (!file.isDirectory()) {
			        	try {
			        		tansfersetup.add(getproperties(file));
							jlogger.info("TransferSetup Reader : File : " + file.getAbsolutePath());
						} catch (IOException e) {
							jlogger.info("Fehler  - TransferSetup Reader : File : " + file.getAbsolutePath() );
						}
			        }
			    }
			return tansfersetup;
		}

		private static TransferSetup getproperties(File file) throws IOException {
			Properties properties = new Properties();
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
			properties.load(stream);
			stream.close();
			TransferSetup temp = new TransferSetup(properties.getProperty("name"), properties.getProperty("file"), properties.getProperty("source"), properties.getProperty("user"), properties.getProperty("pw"), properties.getProperty("server"), properties.getProperty("clear"),properties.getProperty("remotefolder"));
			return temp;
		}
	
}
