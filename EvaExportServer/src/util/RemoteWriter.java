package util;

import java.util.ArrayList;
import java.util.List;

import server.PrinterInterface;

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
