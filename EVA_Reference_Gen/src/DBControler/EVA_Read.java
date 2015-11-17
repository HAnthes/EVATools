package DBControler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EVA_Read {

	public static Connection open(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.57.109.66:1526:EVA1","eva","schalke04");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}
	
}
