package setup;


import java.io.FileInputStream;
import java.io.BufferedInputStream;

import java.io.IOException;

import java.util.Properties;

public class Setup {

	private static String server;
	private static String name;
		
	public static String getServer() {
		return server;
	}

	public static String getName() {
		return name;
	}

	public static void setup() throws IOException{
		String evaprop = System.getProperty("user.dir")
				+ "\\client.properties";
		System.out.println(evaprop);
		Properties properties = new Properties();
		BufferedInputStream stream = new BufferedInputStream(
				new FileInputStream(evaprop));
		properties.load(stream);
		stream.close();
		server = properties.getProperty("server");
		name = properties.getProperty("name");
	}

}
