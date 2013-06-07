package org.g4studio.core.net.ftp;

import org.g4studio.core.net.ftp.parser.RegexFTPFileEntryParserImpl;

/**
 * This abstract class implements both the older FTPFileListParser and newer
 * FTPFileEntryParser interfaces with default functionality. All the classes in
 * the parser subpackage inherit from this.
 * 
 * @author Steve Cohen <scohen@apache.org>
 * @see org.apache.commons.net.ftp.parser.RegexFTPFileEntryParserImpl
 * @deprecated This class is deprecated as of version 1.2 and will be removed in
 *             version 2.0 --
 *             org.apache.commons.net.ftp.RegexFTPFileEntryParserImpl is its
 *             designated replacement. Class has been renamed, entire
 *             implemenation is in RegexFTPFileEntryParserImpl.
 * 
 */
public abstract class FTPFileListParserImpl extends RegexFTPFileEntryParserImpl {
	/**
	 * The constructor for a FTPFileListParserImpl object.
	 * 
	 * @param regex
	 *            The regular expression with which this object is initialized.
	 * 
	 * @exception IllegalArgumentException
	 *                Thrown if the regular expression is unparseable. Should
	 *                not be seen in normal conditions. It it is seen, this is a
	 *                sign that a subclass has been created with a bad regular
	 *                expression. Since the parser must be created before use,
	 *                this means that any bad parser subclasses created from
	 *                this will bomb very quickly, leading to easy detection.
	 */

	public FTPFileListParserImpl(String regex) {
		super(regex);
	}

}

/*
 * Emacs configuration Local variables: ** mode: java ** c-basic-offset: 4 **
 * indent-tabs-mode: nil ** End: **
 */
