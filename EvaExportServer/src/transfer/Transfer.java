package transfer;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.RemoteWriter;
import util.Setup;

public class Transfer {

	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Class.class.getName());
	private static RemoteWriter rw = RemoteWriter.getInstance();

	public static void submit(String setup){
		
		List<TransferSetup> transferSetup = ReadExportSetup.read(setup);
		CountDownLatch sync = new CountDownLatch(transferSetup.size());
		ExecutorService pool = Executors.newCachedThreadPool();
		
		for (TransferSetup s : transferSetup) {
			if (!s.getFilename().equals("none")) {
				jlogger.info("Zipper Start : "  + s.getName());
				Zipper.createZipArchive(s.getSource(), s.getFilename());
			}
			jlogger.info("Transfer Thread Start : "  + s.getName());		
			pool.submit(new FTPTransfer(s,sync));
			}
		pool.shutdown();
		try {
			sync.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jlogger.info("Transfer Ende!");
		rw.print("HTTP Get " + Setup.getService());
		rw.print(HTTPGetter.getHTML(Setup.getService()));
		}
	}
