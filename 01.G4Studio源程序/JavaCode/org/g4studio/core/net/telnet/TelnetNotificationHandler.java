package org.g4studio.core.net.telnet;

/***
 * The TelnetNotificationHandler interface can be used to handle notification of
 * options negotiation commands received on a telnet session.
 * <p>
 * The user can implement this interface and register a
 * TelnetNotificationHandler by using the registerNotificationHandler() of
 * TelnetClient to be notified of option negotiation commands.
 * <p>
 * <p>
 * 
 * @author Bruno D'Avanzo
 ***/

public interface TelnetNotificationHandler {
	/***
	 * The remote party sent a DO command.
	 ***/
	public static final int RECEIVED_DO = 1;

	/***
	 * The remote party sent a DONT command.
	 ***/
	public static final int RECEIVED_DONT = 2;

	/***
	 * The remote party sent a WILL command.
	 ***/
	public static final int RECEIVED_WILL = 3;

	/***
	 * The remote party sent a WONT command.
	 ***/
	public static final int RECEIVED_WONT = 4;

	/***
	 * Callback method called when TelnetClient receives an option negotiation
	 * command.
	 * <p>
	 * 
	 * @param negotiation_code
	 *            - type of negotiation command received (RECEIVED_DO,
	 *            RECEIVED_DONT, RECEIVED_WILL, RECEIVED_WONT)
	 *            <p>
	 * @param option_code
	 *            - code of the option negotiated
	 *            <p>
	 ***/
	public void receivedNegotiation(int negotiation_code, int option_code);
}
