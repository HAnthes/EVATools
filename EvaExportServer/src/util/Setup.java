package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Properties;

public class Setup {

	private static String accessTempl;
	private static String accessWork;
	private static String mobileCSV;
	private static String csv_As24;
	private static String eVAPic;
	private static long touchLastExport;
	private static String picxml;

	private static long mobileErsteSeiteStart;
	private static long mobileErsteSeiteEnde;
	private static long mobileBlickfStart;
	private static long mobileBlickfEnde;
	private static String mobileCSVText="";
	private static String autoscoutCSVText="";
	private static String transfer="";
	private static String fname;
	private static String service;
	private static String pichistorie;
	
	public static void readProp() throws IOException{
		String evaprop = System.getProperty("user.dir") + "\\eva.properties";
	//String evaprop = "D:/EVATranport/Server/eva.properties";
		Properties properties = new Properties();
		BufferedInputStream stream = new BufferedInputStream(
				new FileInputStream(evaprop));
		properties.load(stream);
		stream.close();
		accessTempl = properties.getProperty("AccessFileTemplate");
		accessWork = properties.getProperty("AccessFileOutPut");
		mobileCSV = properties.getProperty("Mobile_CSV");
		mobileErsteSeiteStart = Long.parseLong(properties.getProperty("Mobile_Seite1Start"),10);
		mobileErsteSeiteEnde= Long.parseLong(properties.getProperty("Mobile_Seite1Ende"),10);
		mobileBlickfStart = Long.parseLong(properties.getProperty("Mobile_BlickfStart"),10);
		mobileBlickfEnde = Long.parseLong(properties.getProperty("Mobile_BlickfEnde"),10);
		csv_As24 = properties.getProperty("CSV_AutoScout");
		eVAPic = properties.getProperty("EVAPic");
		picxml=properties.getProperty("PicXML");
		//LastDate �berholt 
		fname = properties.getProperty("TouchLastExport");
		autoscoutCSVText=properties.getProperty("Autoscout_CSV_Text");
		transfer=properties.getProperty("transfer");
		mobileCSVText=properties.getProperty("Mobile_CSV_Text");
		service= properties.getProperty("service");
		pichistorie=properties.getProperty("History");
	}
	public static String getPichistorie() {
		return pichistorie;
	}
	public static String getService() {
		return service;
	}
	public static void makeSetup() throws IOException {
		readProp();
		makeAccess();
		touchLastExport = lastExport(fname);
	}

	public static long getMobileErsteSeiteStart() {
		return mobileErsteSeiteStart;
	}

	public static long getMobileErsteSeiteEnde() {
		return mobileErsteSeiteEnde;
	}

	public static long getMobileBlickfStart() {
		return mobileBlickfStart;
	}

	public static long getMobileBlickfEnde() {
		return mobileBlickfEnde;
	}

	public static void makeAccess() throws IOException {
		File q = new File(getAccessTempl());
		File o = new File(getAccessWork());
		copyFile(q, o);
	}

	private static long lastExport(String datei) throws IOException {
		long help = 0;
		File file = new File(datei);
		
	    try(BufferedReader reader = new BufferedReader(new FileReader(file));) {
	    	   String x = reader.readLine();
	    	   help = Long.parseLong(x,10);
	     } catch (IOException e){
	     }
		
	    try(FileWriter writer = new FileWriter(file ,false);) {
	    	   writer.write(""+ System.currentTimeMillis());
	     } catch (IOException e){
	     }
	 
		return help;
	}
	
	
	public static long getLastExport() throws IOException{
		readProp();
		long help = 0;
		File file = new File(fname);
		
		 try(BufferedReader reader = new BufferedReader(new FileReader(file));) {
	    	   String x = reader.readLine();
	    	   help = Long.parseLong(x,10);
	     } catch (IOException e){
	     }
		 return help;
	}
	
	public static void setLastExport(long goBack) throws IOException{
		
		readProp();
		
		File file = new File(fname);
		
		try(FileWriter writer = new FileWriter(file ,false);) {
	    	   writer.write(""+ goBack );
	     } catch (IOException e){
	     }
	}
	
	
	public static void copyFile(String in, String out) throws IOException{
		File q = new File(in);
		File o = new File(out);
		copyFile(q, o);
	}
	
	private static void copyFile(File in, File out) throws IOException {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			inChannel = new FileInputStream(in).getChannel();
			outChannel = new FileOutputStream(out).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (inChannel != null)
					inChannel.close();
				if (outChannel != null)
					outChannel.close();
			} catch (IOException e) {
			}
		}
	}

	public static String getAccessTempl() {
		return accessTempl;
	}

	public static String getAccessWork() {
		return accessWork;
	}

	public static String getCsv_mobile() {
		return mobileCSV;
	}

	public static String getCsv_As24() {
		return csv_As24;
	}

	public static String geteVAPic() {
		return eVAPic;
	}

	public static String geteVAPic(String datei) {
		return eVAPic + "/" + datei;
	}


	public static long getTouchLastExport() {
		return touchLastExport;
	}
	
	public static String getpicxml() {
		return picxml;
	}
	
	public static String getMobileCSVText() {
		return mobileCSVText;
	}

	public static String getAutoscoutCSVText() {
		return autoscoutCSVText;
	}

	public static String getTransfer() {
		return transfer;
	}
	

}
