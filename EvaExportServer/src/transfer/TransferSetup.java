package transfer;

public class TransferSetup {
	private String name;
	private String filename;
	private String source;
	private String user;
	private String password;
	private String servrer;
	private String clear;
	private String remotefolder;
	
	public TransferSetup(String name, String filename, String source, String user, String password, String servrer, String clear, String remotefolder) {
		super();
		this.name = name;
		this.filename = filename;
		this.source = source;
		this.user = user;
		this.password = password;
		this.servrer = servrer;
		this.clear = clear;
		this.remotefolder = remotefolder;
	}

	public String getName() {
		return name;
	}

	public String getFilename() {
		return filename;
	}

	public String getSource() {
		return source;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getServrer() {
		return servrer;
	}

	public String getClear() {
		return clear;
	}

	public String getRemotefolder(){
		return remotefolder;
	}
	
	@Override
	public String toString() {
		return "TransferSetup [name=" + name + ", filename=" + filename
				+ ", source=" + source + ", user=" + user + ", password="
				+ password + ", servrer=" + servrer + ", clear=" + clear + "]";
	}
	
	
	
}
