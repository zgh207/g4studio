package org.g4studio.core.net.smtp;

import java.io.IOException;

/***
 * SMTPConnectionClosedException is used to indicate the premature or unexpected
 * closing of an SMTP connection resulting from a
 * {@link org.apache.commons.net.smtp.SMTPReply#SERVICE_NOT_AVAILABLE
 * SMTPReply.SERVICE_NOT_AVAILABLE } response (SMTP reply code 421) to a failed
 * SMTP command. This exception is derived from IOException and therefore may be
 * caught either as an IOException or specifically as an
 * SMTPConnectionClosedException.
 * <p>
 * <p>
 * 
 * @author Daniel F. Savarese
 * @see SMTP
 * @see SMTPClient
 ***/

public final class SMTPConnectionClosedException extends IOException {

	/*** Constructs a SMTPConnectionClosedException with no message ***/
	public SMTPConnectionClosedException() {
		super();
	}

	/***
	 * Constructs a SMTPConnectionClosedException with a specified message.
	 * <p>
	 * 
	 * @param message
	 *            The message explaining the reason for the exception.
	 ***/
	public SMTPConnectionClosedException(String message) {
		super(message);
	}

}
