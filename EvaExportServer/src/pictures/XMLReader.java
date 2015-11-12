package pictures;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import util.RemoteWriter;

/**
 * Klasse zur Auswertung der Bildbearbeitungs XML Dateien
 * Alle Dateien im Ordner werden als Bildbarbeiter interpretiert und als RuleSet in die Liste gelegt
 * Logger wird genutzt
 * @author anthes
 *
 */

public class XMLReader {
	
	
	/**
	 * Lesen aller XML Dateien und erzeugen einer Parameterliste
	 */
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Class.class.getName());
	private static  RemoteWriter rw = RemoteWriter.getInstance();		

	
	/**
	 * Durchsucht einen Ordner nach XML Datei
	 * und l‰ﬂt  Auswerten.
	 * 
	 * @param dir
	 * @return
	 */
	public static List<PicBuildRuleSet> getXML (String dir){
		
		List<PicBuildRuleSet> rulesets = new ArrayList<PicBuildRuleSet>();
		File f = new File(dir);
		jlogger.info("XML Ordner " + dir);
		File[] files = f.listFiles();
		
		for (File file : files) {
		        if (!file.isDirectory()) {
		        	try {
						rulesets.add(pictures.XMLReader.readxml(file));
						jlogger.info("XML Set " + file.getAbsolutePath() + " geladen");
						rw.print("XML Reader : Bilderset : " + file.getAbsolutePath());
					} catch (IOException e) {
						jlogger.warning("Fehler bei der XML Verarbeitung : " + e);
					}
		        }
		    }
		return rulesets;
	}
	
	/**
	 * List und verarbeitet eine Set XML
	 * @param datei
	 * @return
	 * @throws IOException
	 */
	private static PicBuildRuleSet readxml(File datei) throws IOException {

		PicBuildRuleSet ruleset = new PicBuildRuleSet();
		Document doc = null;

		File f = datei;
		try {
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(f);
			Element element = doc.getRootElement();
			int x;
			int y;
			int w;
			int h;
			int maxpic;
			String name;
			String output;
			String fallback;

			Element e = element.getChild("template");
			x = e.getAttribute("x").getIntValue();
			y = e.getAttribute("y").getIntValue();
			w = e.getAttribute("w").getIntValue();
			h = e.getAttribute("h").getIntValue();
			name = e.getAttribute("name").getValue();
			ruleset.setTemplate(new PicBuildRule(x, y, w, h));
			ruleset.setTemplateName(name);
			
			e = element.getChild("background");
			x = e.getAttribute("x").getIntValue();
			y = e.getAttribute("y").getIntValue();
			w = e.getAttribute("w").getIntValue();
			h = e.getAttribute("h").getIntValue();
			ruleset.setBackgroud(new PicBuildRule(x, y, w, h));

			e = element.getChild("output");
			output = e.getAttribute("path").getValue();
			ruleset.setOutput(output);
			
			e = element.getChild("start");
			
			int startid  = e.getAttribute("id").getIntValue();
			ruleset.setStartid(startid);
				
			
			if (element.getChild("fill") != null) {
				e = element.getChild("fill");
				if(e.getAttribute("max")!=null){
						maxpic = e.getAttribute("max").getIntValue();
				} else {
					maxpic = 15;
					jlogger.warning("MaxPic nicht per XML gesetzt -  default 15");
				}
				ruleset.setMaxpic(maxpic);
				List<String> k = new ArrayList<String>();
				List<Element> pl = e.getChildren();
				for (Element d : pl) {
					k.add(d.getAttribute("name").getValue());
				}
				ruleset.setFiller(k);
			}
			
			
			if (element.getChild("collage") != null) {
				e = element.getChild("collage");
				if(e.getAttribute("fallback")!=null){
					fallback = e.getAttribute("fallback").getValue();
			} else {
				fallback = "";
				jlogger.warning("Fallback nicht per XML gesetzt -  default >space<");
			}
				ruleset.setFallback(fallback);
				List<PicBuildRule> k = new ArrayList<PicBuildRule>();
				List<Element> pl = e.getChildren();
				for (Element d : pl) {
					x = d.getAttribute("x").getIntValue();
					y = d.getAttribute("y").getIntValue();
					w = d.getAttribute("w").getIntValue();
					h = d.getAttribute("h").getIntValue();
					k.add(new PicBuildRule(x, y, w,h));
				}
				ruleset.setKollage(k);
			}

		} catch (JDOMException e) {
			jlogger.warning("Probleme bei der JDOM Verarbeitung " + e);
		} catch (IOException e) {
			jlogger.warning("Fileerror XML verarbeitung "  + e);
			throw e;
		}
		return ruleset;
	}

}
