package transfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;

import util.RemoteWriter;

/**
 * FTP Transferklasse
 * 
 * @author anthes
 *
 */

public class FTPTransfer implements Runnable {
	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(FTPTransfer.class.getName());
	
	private static RemoteWriter rw = RemoteWriter.getInstance();
	

	private FTPClient ftp = null;
	private TransferSetup transferSetup;
	private CountDownLatch sync;

	public FTPTransfer(TransferSetup transferSetup, CountDownLatch sync) {
		this.transferSetup = transferSetup;
		this.sync = sync;
	
	}

	
	private void logon() throws Exception {

		ftp = new FTPClient();
		ftp.setConnectTimeout(20000);
		ftp.setControlKeepAliveTimeout(300);

		ftp.addProtocolCommandListener(creatProtokollListener());
		ftp.setCopyStreamListener(createListener());
		int reply;
		ftp.connect(transferSetup.getServrer());
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login(transferSetup.getUser(), transferSetup.getPassword());
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
	}

	private void close() {
		if (this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException f) {
				jlogger.info("FTP Fehler : " + f);
			}
		}
	}

	/**
	 * Einzel oder mehr Datei auswählen? Router im bei den Bildern?
	 */
	private void uploadFile() throws Exception {
		File f = new File(transferSetup.getFilename());
		try (InputStream input = new FileInputStream(f)) {
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			this.ftp.storeFile(transferSetup.getRemotefolder() + f.getName(),
					input);
		}
	}

	private void uploadFiles() throws Exception {

		File directory = new File(transferSetup.getSource()); // current
																// directory
		File[] files = directory.listFiles();
		for (File file : files) {
			if (!file.isDirectory()) {
				try (InputStream input = new FileInputStream(file)) {
					ftp.setFileType(FTP.BINARY_FILE_TYPE);
					this.ftp.storeFile(
							transferSetup.getRemotefolder() + file.getName(),
							input);
				}
			}
		}
	}

	private void submit() throws Exception {
		try {
			logon();
			if (transferSetup.getFilename().equals("none")) {
				uploadFiles();
			} else {
				uploadFile();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close();
			clean();
		}
	}

	
	private static ProtocolCommandListener creatProtokollListener() {
		return new ProtocolCommandListener() {
			
			@Override
			public void protocolReplyReceived(ProtocolCommandEvent arg0) {
				rw.print("FTP Thread " + Thread.currentThread().getId() + "  - Message rx > "  + arg0.getMessage());
			}

			@Override
			public void protocolCommandSent(ProtocolCommandEvent arg0) {
				rw.print("FTP Thread " + Thread.currentThread().getId() + "  - Message rx > "  + arg0.getMessage());
			}
		};
	}
	
	private static CopyStreamListener createListener() {
		return new CopyStreamListener() {
			private long megsTotal = 0;
			// @Override
			public void bytesTransferred(CopyStreamEvent event) {
				bytesTransferred(event.getTotalBytesTransferred(), event.getBytesTransferred(), event.getStreamSize());
			}

			// @Override
			 public void bytesTransferred(long totalBytesTransferred,
	                    int bytesTransferred, long streamSize) {
	                long megs = totalBytesTransferred / 1000000;
	                for (long l = megsTotal; l < megs; l++) {
	                    System.err.print("#");
	                }
	                megsTotal = megs;
			}

		};
	}

	private void clean() {
		if (transferSetup.getClear().equals("yes")) {
			if (!transferSetup.getFilename().equals("none")) {
				File dfile = new File(transferSetup.getFilename());
				if (dfile.exists()) {
					jlogger.info("Clean up delete " + dfile.getAbsolutePath());
					rw.print("Aufräumen :  " + dfile.getAbsolutePath());
					dfile.delete();
				}
			}
			File directory = new File(transferSetup.getSource());
			for (File file : directory.listFiles()) {
				jlogger.info("Clean up delete " + file.getAbsolutePath());
				rw.print("Aufräumen :  " + file.getAbsolutePath());
				file.delete();
			}
		}
	}

	@Override
	public void run() {
		try {
			this.submit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sync.countDown();
	}
}
