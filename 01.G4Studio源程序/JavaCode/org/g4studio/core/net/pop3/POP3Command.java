package org.g4studio.core.net.pop3;

/***
 * POP3Command stores POP3 command code constants.
 * <p>
 * <p>
 * 
 * @author Daniel F. Savarese
 ***/

public final class POP3Command {
	/*** Send user name. ***/
	public static final int USER = 0;
	/*** Send password. ***/
	public static final int PASS = 1;
	/*** Quit session. ***/
	public static final int QUIT = 2;
	/*** Get status. ***/
	public static final int STAT = 3;
	/*** List message(s). ***/
	public static final int LIST = 4;
	/*** Retrieve message(s). ***/
	public static final int RETR = 5;
	/*** Delete message(s). ***/
	public static final int DELE = 6;
	/*** No operation. Used as a session keepalive. ***/
	public static final int NOOP = 7;
	/*** Reset session. ***/
	public static final int RSET = 8;
	/*** Authorization. ***/
	public static final int APOP = 9;
	/*** Retrieve top number lines from message. ***/
	public static final int TOP = 10;
	/*** List unique message identifier(s). ***/
	public static final int UIDL = 11;

	static final String[] _commands = { "USER", "PASS", "QUIT", "STAT", "LIST", "RETR", "DELE", "NOOP", "RSET", "APOP",
			"TOP", "UIDL" };

	// Cannot be instantiated.
	private POP3Command() {
	}

	/***
	 * Get the POP3 protocol string command corresponding to a command code.
	 * <p>
	 * 
	 * @return The POP3 protocol string command corresponding to a command code.
	 ***/
	public static final String getCommand(int command) {
		return _commands[command];
	}
}
