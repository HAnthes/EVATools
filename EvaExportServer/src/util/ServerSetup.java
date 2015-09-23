package util;

import java.io.FileInputStream;
import java.io.BufferedInputStream;

import java.io.IOException;

import java.util.Properties;

public class ServerSetup {

	private static String service;
	private static int threads;
	private static int stunde;
	private static int minute;
	//TODO Basisordner für die Properities in einer Configklasse global defineren
	//TODO Auch für das "Arbeitssetup"
	public static void makeSetup() throws IOException {
		//src entfernen für Produktiv Server
		//String prop = System.getProperty("D:/EVATransport/Server/eva.properties");
		String prop = System.getProperty("user.dir")+ "\\server.properties";
		Properties properties = new Properties();
		BufferedInputStream stream = new BufferedInputStream(
				new FileInputStream(prop));
		properties.load(stream);
		stream.close();
		service = properties.getProperty("service");
		threads = Integer.parseInt(properties.getProperty("threads"),10);
		stunde = Integer.parseInt(properties.getProperty("stunde"),10);
		minute = Integer.parseInt(properties.getProperty("minute"),10);
	
	}

	public static String getService() {
		System.out.println(service);
		return service;
	}

	public static int getThreads() {
		return threads;
	}

	public static int getStunde() {
		return stunde;
	}
	public static int getMinute() {
		return minute;
	}
	
	

}
