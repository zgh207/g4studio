package org.g4studio.core.net;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/***
 * DefaultDatagramSocketFactory implements the DatagramSocketFactory interface
 * by simply wrapping the java.net.DatagramSocket constructors. It is the
 * default DatagramSocketFactory used by
 * {@link org.apache.commons.net.DatagramSocketClient} implementations.
 * <p>
 * <p>
 * 
 * @author Daniel F. Savarese
 * @see DatagramSocketFactory
 * @see DatagramSocketClient
 * @see DatagramSocketClient#setDatagramSocketFactory
 ***/

public class DefaultDatagramSocketFactory implements DatagramSocketFactory {

	/***
	 * Creates a DatagramSocket on the local host at the first available port.
	 * <p>
	 * 
	 * @exception SocketException
	 *                If the socket could not be created.
	 ***/
	public DatagramSocket createDatagramSocket() throws SocketException {
		return new DatagramSocket();
	}

	/***
	 * Creates a DatagramSocket on the local host at a specified port.
	 * <p>
	 * 
	 * @param port
	 *            The port to use for the socket.
	 * @exception SocketException
	 *                If the socket could not be created.
	 ***/
	public DatagramSocket createDatagramSocket(int port) throws SocketException {
		return new DatagramSocket(port);
	}

	/***
	 * Creates a DatagramSocket at the specified address on the local host at a
	 * specified port.
	 * <p>
	 * 
	 * @param port
	 *            The port to use for the socket.
	 * @param laddr
	 *            The local address to use.
	 * @exception SocketException
	 *                If the socket could not be created.
	 ***/
	public DatagramSocket createDatagramSocket(int port, InetAddress laddr) throws SocketException {
		return new DatagramSocket(port, laddr);
	}
}
