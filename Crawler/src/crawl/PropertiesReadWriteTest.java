package crawl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesReadWriteTest {

	public static void main(String[] args) {
		String prop =  "D:/test.properties";
		Properties properties = new Properties();
		BufferedInputStream stream;
	
		//Holen
		try {
			stream = new BufferedInputStream(new FileInputStream(prop));
			properties.load(stream);
			stream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Properties p2 = new Properties();
		//Ändern
		for(Entry<Object, Object> e : properties.entrySet()){
			  System.out.println(e.getKey() + " = " + e.getValue());
			  p2.setProperty(e.getKey().toString(), e.getValue().toString()+"AAA");
			}
			 
	//Anfügen
	if (properties.get("fgxh") == null)	{
		System.out.println("Setzte");
		p2.setProperty("fgxh", "Radieschen");
	}
	else
	{
		System.out.println("Vorhanden");
	}
	
	//Schreiben
	try {
		FileOutputStream out = new FileOutputStream(prop);
		
		p2.store(out,"Neu");
		out.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
