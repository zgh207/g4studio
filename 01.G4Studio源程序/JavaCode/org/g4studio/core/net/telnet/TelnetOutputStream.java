package org.g4studio.core.net.telnet;

import java.io.IOException;
import java.io.OutputStream;

/***
 * 
 * <p>
 * 
 * <p>
 * <p>
 * 
 * @author Daniel F. Savarese
 ***/

final class TelnetOutputStream extends OutputStream {
	private TelnetClient __client;
	private boolean __convertCRtoCRLF = true;
	private boolean __lastWasCR = false;

	TelnetOutputStream(TelnetClient client) {
		__client = client;
	}

	/***
	 * Writes a byte to the stream.
	 * <p>
	 * 
	 * @param ch
	 *            The byte to write.
	 * @exception IOException
	 *                If an error occurs while writing to the underlying stream.
	 ***/
	public void write(int ch) throws IOException {

		synchronized (__client) {
			ch &= 0xff;

			if (__client._requestedWont(TelnetOption.BINARY)) {
				if (__lastWasCR) {
					if (__convertCRtoCRLF) {
						__client._sendByte('\n');
						if (ch == '\n') {
							__lastWasCR = false;
							return;
						}
					} else if (ch != '\n')
						__client._sendByte('\0');
				}

				__lastWasCR = false;

				switch (ch) {
				case '\r':
					__client._sendByte('\r');
					__lastWasCR = true;
					break;
				case TelnetCommand.IAC:
					__client._sendByte(TelnetCommand.IAC);
					__client._sendByte(TelnetCommand.IAC);
					break;
				default:
					__client._sendByte(ch);
					break;
				}
			} else if (ch == TelnetCommand.IAC) {
				__client._sendByte(ch);
				__client._sendByte(TelnetCommand.IAC);
			} else
				__client._sendByte(ch);
		}
	}

	/***
	 * Writes a byte array to the stream.
	 * <p>
	 * 
	 * @param buffer
	 *            The byte array to write.
	 * @exception IOException
	 *                If an error occurs while writing to the underlying stream.
	 ***/
	public void write(byte buffer[]) throws IOException {
		write(buffer, 0, buffer.length);
	}

	/***
	 * Writes a number of bytes from a byte array to the stream starting from a
	 * given offset.
	 * <p>
	 * 
	 * @param buffer
	 *            The byte array to write.
	 * @param offset
	 *            The offset into the array at which to start copying data.
	 * @param length
	 *            The number of bytes to write.
	 * @exception IOException
	 *                If an error occurs while writing to the underlying stream.
	 ***/
	public void write(byte buffer[], int offset, int length) throws IOException {
		synchronized (__client) {
			while (length-- > 0)
				write(buffer[offset++]);
		}
	}

	/*** Flushes the stream. ***/
	public void flush() throws IOException {
		__client._flushOutputStream();
	}

	/*** Closes the stream. ***/
	public void close() throws IOException {
		__client._closeOutputStream();
	}
}
