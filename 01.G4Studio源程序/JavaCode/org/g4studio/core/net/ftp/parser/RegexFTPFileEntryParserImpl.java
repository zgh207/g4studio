package org.g4studio.core.net.ftp.parser;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.g4studio.core.net.ftp.FTPFileEntryParserImpl;

/**
 * This abstract class implements both the older FTPFileListParser and newer
 * FTPFileEntryParser interfaces with default functionality. All the classes in
 * the parser subpackage inherit from this.
 * 
 * This is the base for all regular based FTPFileEntryParser
 * 
 * @author Steve Cohen <scohen@apache.org>
 */
public abstract class RegexFTPFileEntryParserImpl extends FTPFileEntryParserImpl {
	/**
	 * internal pattern the matcher tries to match, representing a file entry
	 */
	private Pattern pattern = null;

	/**
	 * internal match result used by the parser
	 */
	private MatchResult result = null;

	/**
	 * Internal PatternMatcher object used by the parser. It has protected scope
	 * in case subclasses want to make use of it for their own purposes.
	 */
	protected PatternMatcher _matcher_ = null;

	/**
	 * The constructor for a RegexFTPFileEntryParserImpl object.
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

	public RegexFTPFileEntryParserImpl(String regex) {
		super();
		try {
			_matcher_ = new Perl5Matcher();
			pattern = new Perl5Compiler().compile(regex);
		} catch (MalformedPatternException e) {
			throw new IllegalArgumentException("Unparseable regex supplied:  " + regex);
		}
	}

	/**
	 * Convenience method delegates to the internal MatchResult's matches()
	 * method.
	 * 
	 * @param s
	 *            the String to be matched
	 * @return true if s matches this object's regular expression.
	 */

	public boolean matches(String s) {
		this.result = null;
		if (_matcher_.matches(s.trim(), this.pattern)) {
			this.result = _matcher_.getMatch();
		}
		return null != this.result;
	}

	/**
	 * Convenience method delegates to the internal MatchResult's groups()
	 * method.
	 * 
	 * @return the number of groups() in the internal MatchResult.
	 */

	public int getGroupCnt() {
		if (this.result == null) {
			return 0;
		}
		return this.result.groups();
	}

	/**
	 * Convenience method delegates to the internal MatchResult's group()
	 * method.
	 * 
	 * @param matchnum
	 *            match group number to be retrieved
	 * 
	 * @return the content of the <code>matchnum'th<code> group of the internal
	 *         match or null if this method is called without a match having
	 *         been made.
	 */
	public String group(int matchnum) {
		if (this.result == null) {
			return null;
		}
		return this.result.group(matchnum);
	}

	/**
	 * For debugging purposes - returns a string shows each match group by
	 * number.
	 * 
	 * @return a string shows each match group by number.
	 */

	public String getGroupsAsString() {
		StringBuffer b = new StringBuffer();
		for (int i = 1; i <= this.result.groups(); i++) {
			b.append(i).append(") ").append(this.result.group(i)).append(System.getProperty("line.separator"));
		}
		return b.toString();
	}

}
