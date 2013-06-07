package org.g4studio.core.net.ftp.parser;

import org.g4studio.core.net.ftp.FTPFile;
import org.g4studio.core.net.ftp.FTPFileEntryParser;
import org.g4studio.core.net.ftp.FTPFileEntryParserImpl;

/**
 * This implementation allows to pack some FileEntryParsers together
 * and handle the case where to returned dirstyle isnt clearly defined.
 * The matching parser will be cached.
 * If the cached parser wont match due to the server changed the dirstyle,
 * a new matching parser will be searched.
 *
 * @author Mario Ivankovits <mario@ops.co.at>
 */
public class CompositeFileEntryParser extends FTPFileEntryParserImpl
{
    private final FTPFileEntryParser[] ftpFileEntryParsers;
    private FTPFileEntryParser cachedFtpFileEntryParser;

    public CompositeFileEntryParser(FTPFileEntryParser[] ftpFileEntryParsers)
    {
        super();

        this.cachedFtpFileEntryParser = null;
        this.ftpFileEntryParsers = ftpFileEntryParsers;
    }

    public FTPFile parseFTPEntry(String listEntry)
    {
        if (cachedFtpFileEntryParser != null)
        {
            FTPFile matched = cachedFtpFileEntryParser.parseFTPEntry(listEntry);
            if (matched != null)
            {
                return matched;
            }
        }
        else
        {
            for (int iterParser=0; iterParser < ftpFileEntryParsers.length; iterParser++)
            {
                FTPFileEntryParser ftpFileEntryParser = ftpFileEntryParsers[iterParser];

                FTPFile matched = ftpFileEntryParser.parseFTPEntry(listEntry);
                if (matched != null)
                {
                    cachedFtpFileEntryParser = ftpFileEntryParser;
                    return matched;
                }
            }
        }
        return null;
    }
}
