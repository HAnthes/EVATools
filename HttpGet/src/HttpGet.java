import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpGet {
	 static String getHTML(String urlToRead) {
	      URL url;
	      HttpURLConnection conn;
	      BufferedReader rd;
	      String line;
	      StringBuilder result = new StringBuilder();
	      try {
	         url = new URL(urlToRead);
	         conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         while ((line = rd.readLine()) != null) {
	            result.append(line);
	         }
	         rd.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return result.toString();
	}
	public static void main(String[] args) {
		System.out.println(getHTML("http://www.holderbaum.de/config/system/reorg.asp"));
	}

}
