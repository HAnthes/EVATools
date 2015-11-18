package pictures;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import model.Vehicle;
import model.VehiclesMm;
import server.RemoteWriter;
import util.Setup;
/**
 * Worker Classe für Bilderverarbeitungsthread
 * @author anthes
 * Loggin nachtragen
 *
 */
public class PictureWorker implements Runnable {
	private static RemoteWriter rw = RemoteWriter.getInstance();
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Class.class.getName());
	private PicBuildRuleSet rs;
	private ArrayBlockingQueue<Vehicle> pipe;
	private CountDownLatch sync;
	
	public PictureWorker(PicBuildRuleSet rs, ArrayBlockingQueue<Vehicle> pipe, CountDownLatch sync){
		this.sync = sync;
		this.rs = rs;
		this.pipe = pipe;		
	}


	public void run() {
		Vehicle temp;
		 try {
			rw.print("Bilderworker : " + Thread.currentThread().getId() + "  : Start");   
			 while(true) {
	                temp = this.pipe.poll(5,TimeUnit.SECONDS);
	                if (temp==null){
	                	 jlogger.info(Thread.currentThread().getId() + "  Queue leer");
	                	 rw.print("Bildbearbeitung : " + Thread.currentThread().getId() + "  Queue leer");
	                	 break;
	                }
	                rw.print("Bildbearbeitung : " + Thread.currentThread().getId() + " Fahrzeug :" +  temp.getOrderNo());
	                jlogger.info(Thread.currentThread().getId() + "  -  " + temp.getOrderNo());
	                try {
						pictureRouter( temp, rs );
					} catch (IOException e) {	
						jlogger.warning("Dateifehler beim Worker : " + e);
					}
	            }
	        } catch (InterruptedException e) {
	        	jlogger.warning("Interrupt beim Worker : " + e);
	        }
		 rw.print("Bilderworker : " + Thread.currentThread().getId() + "  : Ende");   
		 sync.countDown();
	}
	
	
	/**
	 * Verteilt je nach Ruleset auf verschiedene Arbeitermethoden
	 * @param car
	 * @param ruleset
	 * @throws IOException
	 */
	private static void pictureRouter(Vehicle car, PicBuildRuleSet ruleset)	throws IOException {
		if(car.getVehiclesMms()!=null)
		{
		//TODO Anpassen auf dei Fallback PRoblematik!!!! (&& car.getVehiclesMms().size() >= ruleset.getKollage().size())
		jlogger.info("Verteilen : " + car.getVehicleNo() + " " + ruleset.getTemplateName());
		if (ruleset.getKollage() != null ){
				workerMultipicture(car, ruleset);
		} else {
				workerSinglepicture(car,ruleset);
			}
		}
	
	}
	
	
	/**
	 * Stellt ein Bild aus mehreren Bilder zusammen.
	 * Reichen die FZG Bilder nicht wird statt dessen ein Fallbackbild (Parameter in der XML) einstellt
	 * @param car
	 * @param ruleset
	 * @throws IOException
	 */
	private static void workerMultipicture(Vehicle car, PicBuildRuleSet ruleset) throws IOException {
		
		BufferedImage tmpl = ImageIO.read(new File(ruleset.getTemplateName()));
		
		Image it = tmpl.getScaledInstance((int)ruleset.getTemplate().getDimension().getWidth(),(int)ruleset.getTemplate().getDimension().getHeight(), Image.SCALE_SMOOTH);	
		int index=ruleset.getStartid()+1;
		//Sind genug Bildervorhanden oder soll das FAllbackBild genutzt werden.
		if(ruleset.getKollage().size()<=car.getVehiclesMms().size()){
			jlogger.info(ruleset.getTemplateName() + " erstellen");
			//Templategröße verwenden!
			BufferedImage base = new BufferedImage((int)ruleset.getTemplate().getDimension().getWidth(), (int)ruleset.getTemplate().getDimension().getHeight(), BufferedImage.TYPE_INT_RGB);
		
			Graphics2D g2 = base.createGraphics();
		
			//Bild für den Hintergrund - Hintergrund Temlpate Bilder-....
			BufferedImage bg=ImageIO.read(new File(Setup.geteVAPic() + "/" + car.getVehiclesMms().get(0).getFilename()));
			Image ib = bg.getScaledInstance((int)ruleset.getBackgroud().getDimension().getWidth(),(int)ruleset.getBackgroud().getDimension().getHeight(), Image.SCALE_SMOOTH);
			g2.drawImage(ib, 0,0 , null);
			g2.drawImage(it, (int)ruleset.getTemplate().getLocation().getX(),(int)ruleset.getTemplate().getLocation().getY(),null);
	
			for(PicBuildRule kc : ruleset.getKollage() ){
				BufferedImage kb = ImageIO.read(new File(Setup.geteVAPic() + "/" + car.getVehiclesMms().get(index).getFilename()));
				Image ki = kb.getScaledInstance((int)kc.getDimension().getWidth(),(int)kc.getDimension().getHeight(), Image.SCALE_SMOOTH);
				g2.drawImage(ki,(int)kc.getLocation().getX(),(int)kc.getLocation().getY(), null);
				index++;
			}
			g2.dispose();
			ImageIO.write(base, "JPEG", new File(ruleset.getOutput()+"/" + car.getVehicleNo() + "_"+ ruleset.getStartid()+".jpg"));
			
		} else
		{
			jlogger.info("Bilderzahl passt nicht -> Fallback!");
			jlogger.info("Fallbackpinkt : " + car.getVehicleNo() + "_"+ ruleset.getStartid()+".jpg");
			//Falls nichts dann halt  nichts!
			if(ruleset.getFallback()!=""){
				jlogger.info(ruleset.getTemplateName() + " Fallback");
				Setup.copyFile(ruleset.getFallback(), ruleset.getOutput()+"/" + car.getVehicleNo() + "_"+ ruleset.getStartid() +".jpg");
			}
		}
	}
	
	/**
	 * Erzeugt einzel Bilder pro FZG. 
	 * maxpic begrenzt das anfügen von Fillerbilder
	 * der Indexstart wird in der XML definiert. 
	 * @param car
	 * @param ruleset
	 * @throws IOException
	 */
	private static void workerSinglepicture(Vehicle car, PicBuildRuleSet ruleset) throws IOException {
		
		double x = ruleset.getBackgroud().getDimension().getWidth();
		double y = ruleset.getBackgroud().getDimension().getHeight();
		BufferedImage tmpl = ImageIO.read(new File(ruleset.getTemplateName()));
		Image it = tmpl.getScaledInstance((int)ruleset.getTemplate().getDimension().getWidth(),(int)ruleset.getTemplate().getDimension().getHeight(), Image.SCALE_SMOOTH);	
		int index = ruleset.getStartid();
		jlogger.info(ruleset.getTemplateName() + " erstellen");
		for(VehiclesMm mm : car.getVehiclesMms() ){
			BufferedImage base = new BufferedImage((int)x, (int)y,	BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = base.createGraphics();
			BufferedImage bg = ImageIO.read(new File(Setup.geteVAPic() + "/" + mm.getFilename()));
		
			Image ib = bg.getScaledInstance((int)x,(int)y, Image.SCALE_SMOOTH);
			g2.drawImage(ib, 0,0 , null);
			g2.drawImage(it, (int)ruleset.getTemplate().getLocation().getX(),(int)ruleset.getTemplate().getLocation().getY(),null);
			g2.dispose();
		
			ImageIO.write(base, "JPEG", new File(ruleset.getOutput()+"/" + car.getVehicleNo() + "_"+ index +".jpg"));
			index++;
		}
		//Prüfung der Maxpicangabe?!? Verhalten bei Fallbackpic? 
		if(car.getVehiclesMms().size() + ruleset.getFiller().size() <= ruleset.getMaxpic()){
			jlogger.info(ruleset.getTemplateName() + " Max " + car.getVehiclesMms().size() + ruleset.getFiller().size() );
			for(String dateien : ruleset.getFiller()){
				Setup.copyFile(dateien, ruleset.getOutput()+"/" + car.getVehicleNo() + "_"+ index +".jpg");
				index++;
			}
		rw.print("Filler :" + index );
		}
	}
}
