package org.g4studio.core.net.nntp;

import java.io.IOException;

/***
 * NNTPConnectionClosedException is used to indicate the premature or unexpected
 * closing of an NNTP connection resulting from a
 * {@link org.apache.commons.net.nntp.NNTPReply#SERVICE_DISCONTINUED
 * NNTPReply.SERVICE_DISCONTINUED } response (NNTP reply code 400) to a failed
 * NNTP command. This exception is derived from IOException and therefore may be
 * caught either as an IOException or specifically as an
 * NNTPConnectionClosedException.
 * <p>
 * <p>
 * 
 * @author Daniel F. Savarese
 * @see NNTP
 * @see NNTPClient
 ***/

public final class NNTPConnectionClosedException extends IOException {

	/*** Constructs a NNTPConnectionClosedException with no message ***/
	public NNTPConnectionClosedException() {
		super();
	}

	/***
	 * Constructs a NNTPConnectionClosedException with a specified message.
	 * <p>
	 * 
	 * @param message
	 *            The message explaining the reason for the exception.
	 ***/
	public NNTPConnectionClosedException(String message) {
		super(message);
	}

}
