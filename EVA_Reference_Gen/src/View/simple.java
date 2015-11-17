package View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DBControler.EVA_Read;

public class simple {
	 
	public static void main(String[] args) throws SQLException {
		Statement stmt = null;
	    ResultSet rs = null;
	    String sql = "select * from vehicles where VEHICLE_NO=34804";
	    Vector<String> columnNames = new Vector<String>();
	    
	    Connection conn = EVA_Read.open();
		stmt = conn.createStatement();
	     rs = stmt.executeQuery(sql);
	     if (rs != null) {
	        ResultSetMetaData columns = rs.getMetaData();
	        int i = 0;
	        while (i < columns.getColumnCount()) {
	          i++;
	          columnNames.add(columns.getColumnName(i));
	        }
	    
	        while (rs.next()) {
	          for (i = 0; i < columnNames.size(); i++) {
	            System.out.print(columnNames.get(i)+ "\t\t\t" + rs.getString(columnNames.get(i))
	                + "\n");

	          }
	          System.out.print("\n");
	        }

	      }
	          rs.close();
	          stmt.close();
	          conn.close();
	        }
	  
	
}

	    
