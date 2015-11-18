package server;

import java.util.ArrayList;
import java.util.List;

public class RemoteWriter {

	private  List<PrinterInterface> printers = new ArrayList<PrinterInterface>();
	private static final class InstanceHolder{
		static final RemoteWriter INSTANCE  = new RemoteWriter();
	}

	private RemoteWriter(){
	}
	
	public static RemoteWriter getInstance(){
		return InstanceHolder.INSTANCE;
	}

	public void setPrinter(PrinterInterface pi){
		printers.add(pi);
	}

	public  void print(String text){
		
		for (PrinterInterface printer : printers){
			printer.print(text);	
		}
		
	}
}
