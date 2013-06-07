package org.g4studio.core.net.ftp;

import org.g4studio.core.net.ftp.parser.UnixFTPEntryParser;

/**
 * DefaultFTPFileListParser is the default implementation of
 * {@link org.apache.commons.net.ftp.FTPFileListParser} used by
 * {@link org.apache.commons.net.ftp.FTPClient} to parse file listings.
 * Sometimes you will want to parse unusual listing formats, in which case you
 * would create your own implementation of FTPFileListParser and if necessary,
 * subclass FTPFile.
 * <p>
 * As of version 1.2, this class merely extends UnixFTPEntryParser. It will be
 * removed in version 2.0.
 * <p>
 * 
 * @author Daniel F. Savarese
 * @see FTPFileListParser
 * @see FTPFile
 * @see FTPClient#listFiles
 * @see org.apache.commons.net.ftp.parser.DefaultFTPFileEntryParserFactory
 * @deprecated This class is deprecated as of version 1.2 and will be removed in
 *             version 2.0 -- use the autodetect mechanism in
 *             DefaultFTPFileEntryParserFactory instead.
 */
public final class DefaultFTPFileListParser extends UnixFTPEntryParser {

}
