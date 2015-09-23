package crawl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Crawler {


    final String[] KEYWORDS = {"."};
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        new Crawler().doIt("http://www.heise.de/");
        System.out.println(System.currentTimeMillis() - time);
    }
 
 
    private void doIt(String s) {
        // TODO Auto-generated method stub
 
        BufferedReader br = null;
        InputStreamReader isr = null;
        URL url = null;
        try {
            url = new URL(s);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        if (url != null) {
            try {
                isr = new InputStreamReader(url.openStream());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            br = new BufferedReader(isr);
 
            String line = null;
            File file = new File("temp.txt");
            FileOutputStream ausgabe = null;
            try {
                ausgabe = new FileOutputStream(file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            DataOutputStream raus = new DataOutputStream(ausgabe);
            try {
                while ((line = br.readLine()) != null) {
                    if (checkKeyWords(line)) {
                        try {
                            raus.writeBytes(line+"\n");
                        }
                        catch (IOException e) {
                        }
                        System.out.println(line);
                    }
                }
 
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
 
        }
 
    }
 
 
    private boolean checkKeyWords(String line) {
        // TODO Auto-generated method stub
 
        for (int i = 0; i < KEYWORDS.length; i++) {
            if (line.indexOf(KEYWORDS[i]) >= 0)
                return true;
        }
 
        return false;
    }
}