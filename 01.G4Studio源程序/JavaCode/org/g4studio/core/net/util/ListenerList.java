package org.g4studio.core.net.util;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Vector;

/**
 * @author Daniel F. Savarese
 */

public class ListenerList implements Serializable {
	private Vector __listeners;

	public ListenerList() {
		__listeners = new Vector();
	}

	public synchronized void addListener(EventListener listener) {
		__listeners.addElement(listener);
	}

	public synchronized void removeListener(EventListener listener) {
		__listeners.removeElement(listener);
	}

	public synchronized Enumeration getListeners() {
		return ((Vector) __listeners.clone()).elements();
	}

	public int getListenerCount() {
		return __listeners.size();
	}

}
