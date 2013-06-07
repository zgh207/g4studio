package org.g4studio.core.net.tftp;

/***
 * A class used to signify the occurrence of an error in the creation of a TFTP
 * packet. It is not declared final so that it may be subclassed to identify
 * more specific errors. You would only want to do this if you were building
 * your own TFTP client or server on top of the
 * {@link org.apache.commons.net.tftp.TFTP} class if you wanted more
 * functionality than the
 * {@link org.apache.commons.net.tftp.TFTPClient#receiveFile receiveFile()} and
 * {@link org.apache.commons.net.tftp.TFTPClient#sendFile sendFile()} methods
 * provide.
 * <p>
 * <p>
 * 
 * @author Daniel F. Savarese
 * @see TFTPPacket
 * @see TFTP
 ***/

public class TFTPPacketException extends Exception {

	/***
	 * Simply calls the corresponding constructor of its superclass.
	 ***/
	public TFTPPacketException() {
		super();
	}

	/***
	 * Simply calls the corresponding constructor of its superclass.
	 ***/
	public TFTPPacketException(String message) {
		super(message);
	}
}
