package org.g4studio.core.net.telnet;

/***
 * The InvalidTelnetOptionException is the exception that is thrown whenever a
 * TelnetOptionHandler with an invlaid option code is registered in TelnetClient
 * with addOptionHandler.
 * <p>
 * 
 * @author Bruno D'Avanzo
 ***/
public class InvalidTelnetOptionException extends Exception {

	/***
	 * Option code
	 ***/
	private int optionCode = -1;

	/***
	 * Error message
	 ***/
	private String msg;

	/***
	 * Constructor for the exception.
	 * <p>
	 * 
	 * @param message
	 *            - Error message.
	 * @param optcode
	 *            - Option code.
	 ***/
	public InvalidTelnetOptionException(String message, int optcode) {
		optionCode = optcode;
		msg = message;
	}

	/***
	 * Gets the error message of ths exception.
	 * <p>
	 * 
	 * @return the error message.
	 ***/
	public String getMessage() {
		return (msg + ": " + optionCode);
	}
}
