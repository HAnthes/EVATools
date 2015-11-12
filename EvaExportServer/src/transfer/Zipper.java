package transfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * Zipper - statische Klasse. 
 * Zippt Ordner und einzeldateien - keine Subdirs.
 * @author anthes
 *
 */
public class Zipper {
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Class.class.getName()); 
	
	public static boolean createZipArchive(String srcFolder, String zip) {
		int BUFFER = 2048;
		try {
			BufferedInputStream origin = null;
			FileOutputStream dest = new FileOutputStream(new File(zip));
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
			byte data[] = new byte[BUFFER];
				File f = new File(srcFolder);
				if (f.isDirectory()){
					for (File z : f.listFiles()) {
						jlogger.info("Zipper (dir) : adding : " + z.getName());
				
						FileInputStream fi = new FileInputStream(z);
						origin = new BufferedInputStream(fi, BUFFER);
						ZipEntry entry = new ZipEntry(z.getName());
						out.putNextEntry(entry);
						int count;
						while ((count = origin.read(data, 0, BUFFER)) != -1) {
							out.write(data, 0, count);
							out.flush();
						}
						origin.close();
						out.flush();
					}
					
				} else 
				{
					FileInputStream fi = new FileInputStream(f);
					origin = new BufferedInputStream(fi, BUFFER);
					jlogger.info("Zipper (sig): adding : " + f.getName());
					ZipEntry entry = new ZipEntry(f.getName());
					out.putNextEntry(entry);
					int count;
					while ((count = origin.read(data, 0, BUFFER)) != -1) {
						out.write(data, 0, count);
						out.flush();
					}
					origin.close();
					out.flush();
				}
			
		
			out.close();
		} catch (Exception e) {
			jlogger.info("Zipper : Fehler beim erstellen der Zipdatei " + e.getMessage());
			return false;
		}

		return true;
	}
}
