package org.g4studio.core.net.nntp;

/**
 * A placeholder interface for threadable message objects Author: Rory Winston
 * <rwinston@checkfree.com>
 * 
 */
public interface Threadable {
	public boolean isDummy();

	public String messageThreadId();

	public String[] messageThreadReferences();

	public String simplifiedSubject();

	public boolean subjectIsReply();

	public void setChild(Threadable child);

	public void setNext(Threadable next);

	public Threadable makeDummy();
}