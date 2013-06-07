package org.g4studio.core.net.ftp.parser;

import org.g4studio.core.net.ftp.FTPClientConfig;
import org.g4studio.core.net.ftp.FTPFileEntryParser;

/**
 * The interface describes a factory for creating FTPFileEntryParsers.
 * 
 * @since 1.2
 */
public interface FTPFileEntryParserFactory {
	/**
	 * Implementation should be a method that decodes the supplied key and
	 * creates an object implementing the interface FTPFileEntryParser.
	 * 
	 * @param key
	 *            A string that somehow identifies an FTPFileEntryParser to be
	 *            created.
	 * 
	 * @return the FTPFileEntryParser created.
	 * @exception ParserInitializationException
	 *                Thrown on any exception in instantiation
	 */
	public FTPFileEntryParser createFileEntryParser(String key) throws ParserInitializationException;

	/**
	 * <p>
	 * Implementation should be a method that extracts a key from the supplied
	 * {@link FTPClientConfig FTPClientConfig} parameter and creates an object
	 * implementing the interface FTPFileEntryParser and uses the supplied
	 * configuration to configure it.
	 * </p>
	 * <p>
	 * Note that this method will generally not be called in scenarios that call
	 * for autodetection of parser type but rather, for situations where the
	 * user knows that the server uses a non-default configuration and knows
	 * what that configuration is.
	 * </p>
	 * 
	 * @param config
	 *            A {@link FTPClientConfig FTPClientConfig} used to configure
	 *            the parser created
	 * 
	 * @return the @link FTPFileEntryParser FTPFileEntryParser} so created.
	 * @exception ParserInitializationException
	 *                Thrown on any exception in instantiation
	 * @since 1.4
	 */
	public FTPFileEntryParser createFileEntryParser(FTPClientConfig config) throws ParserInitializationException;

}
