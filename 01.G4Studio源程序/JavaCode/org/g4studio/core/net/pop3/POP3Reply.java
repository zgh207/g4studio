package org.g4studio.core.net.pop3;

/***
 * POP3Reply stores POP3 reply code constants.
 * <p>
 * <p>
 * 
 * @author Daniel F. Savarese
 ***/

public final class POP3Reply {
	/*** The reply code indicating success of an operation. ***/
	public static int OK = 0;

	/*** The reply code indicating failure of an operation. ***/
	public static int ERROR = 1;

	// Cannot be instantiated.
	private POP3Reply() {
	}
}
