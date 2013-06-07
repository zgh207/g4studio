package org.g4studio.core.net.ftp;

import java.io.IOException;

/***
 * FTPConnectionClosedException is used to indicate the premature or unexpected
 * closing of an FTP connection resulting from a
 * {@link org.apache.commons.net.ftp.FTPReply#SERVICE_NOT_AVAILABLE
 * FTPReply.SERVICE_NOT_AVAILABLE } response (FTP reply code 421) to a failed
 * FTP command. This exception is derived from IOException and therefore may be
 * caught either as an IOException or specifically as an
 * FTPConnectionClosedException.
 * <p>
 * <p>
 * 
 * @author Daniel F. Savarese
 * @see FTP
 * @see FTPClient
 ***/

public class FTPConnectionClosedException extends IOException {

	/*** Constructs a FTPConnectionClosedException with no message ***/
	public FTPConnectionClosedException() {
		super();
	}

	/***
	 * Constructs a FTPConnectionClosedException with a specified message.
	 * <p>
	 * 
	 * @param message
	 *            The message explaining the reason for the exception.
	 ***/
	public FTPConnectionClosedException(String message) {
		super(message);
	}

}
