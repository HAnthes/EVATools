package pictures;


import java.util.ArrayList;
import java.util.List;

public class PicBuildRuleSet {
	/**
	 * pojo XML inport Bilderauftragsbeschreibung
	 * List kollage unterscheidung von für alle n+1 oder wenn liste nicht null Bild 1 als Kollage
	 * @author anthes
	 *	
	 */
	
	private List<PicBuildRule> kollage;
	private PicBuildRule backgroud;
	private PicBuildRule template;
	private String templateName;
	private String fallback;
	public String getFallback() {
		return fallback;
	}

	public void setFallback(String fallback) {
		this.fallback = fallback;
	}

	private String output;
	private int startid;
	private int maxpic;
	public int getMaxpic() {
		return maxpic;
	}

	public void setMaxpic(int maxpic) {
		this.maxpic = maxpic;
	}

	private List<String> filler = new ArrayList<String>();
	
	public List<String> getFiller() {
		return filler;
	}

	public void setFiller(List<String> filler) {
		this.filler = filler;
	}

	public int getStartid() {
		return startid;
	}

	public void setStartid(int startid) {
		this.startid = startid;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public PicBuildRuleSet() {
	}

	public List<PicBuildRule> getKollage() {
		return kollage;
	}

	public void setKollage(List<PicBuildRule> kollage) {
		this.kollage = kollage;
	}

	public PicBuildRule getBackgroud() {
		return backgroud;
	}

	public void setBackgroud(PicBuildRule backgroud) {
		this.backgroud = backgroud;
	}

	public PicBuildRule getTemplate() {
		return template;
	}

	public void setTemplate(PicBuildRule template) {
		this.template = template;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Override
	public String toString() {
		return "PicBuildRuleSet [kollage=" + kollage + ", backgroud="
				+ backgroud + ", template=" + template + ", templateName="
				+ templateName + ", output=" + output + "]";
	}
	
}
