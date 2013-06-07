package org.g4studio.core.net.nntp;

/**
 * This class is a structure used to return article number and unique id
 * information extracted from an NNTP server reply. You will normally want this
 * information when issuing a STAT command, implemented by
 * {@link NNTPClient#selectArticle selectArticle}.
 * 
 * @author Daniel F. Savarese
 * @see NNTPClient
 */
public final class ArticlePointer {
	/** The number of the referenced article. */
	public int articleNumber;
	/**
	 * The unique id of the referenced article, including the enclosing &lt and
	 * &gt symbols which are technically not part of the identifier, but are
	 * required by all NNTP commands taking an article id as an argument.
	 */
	public String articleId;
}
