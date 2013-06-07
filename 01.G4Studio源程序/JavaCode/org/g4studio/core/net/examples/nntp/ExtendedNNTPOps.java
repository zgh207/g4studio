package org.g4studio.core.net.examples.nntp;

import java.io.IOException;
import java.io.PrintWriter;

import org.g4studio.core.net.examples.PrintCommandListener;
import org.g4studio.core.net.nntp.Article;
import org.g4studio.core.net.nntp.NNTPClient;
import org.g4studio.core.net.nntp.NewsgroupInfo;

/**
 * Simple class showing some of the extended commands (AUTH, XOVER, LIST ACTIVE)
 * 
 * @author Rory Winston <rwinston@checkfree.com>
 */
public class ExtendedNNTPOps {

	
	NNTPClient client;

	public ExtendedNNTPOps() {
		client = new NNTPClient();
		client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
	}


	public void demo(String host, String user, String password) {
		try {
			client.connect(host);

			// AUTHINFO USER/AUTHINFO PASS
			boolean success = client.authenticate(user, password);
			if (success) {
				System.out.println("Authentication succeeded");
			} else {
				System.out.println("Authentication failed, error =" + client.getReplyString());
			}

			// XOVER
			NewsgroupInfo testGroup = new NewsgroupInfo();
			client.selectNewsgroup("alt.test", testGroup);
			int lowArticleNumber = testGroup.getFirstArticle();
			int highArticleNumber = lowArticleNumber + 100;
			Article[] articles = NNTPUtils.getArticleInfo(client, lowArticleNumber, highArticleNumber);

			for (int i = 0; i < articles.length; ++i) {
				System.out.println(articles[i].getSubject());
			}

			// LIST ACTIVE
			NewsgroupInfo[] fanGroups = client.listNewsgroups("alt.fan.*");
			for (int i = 0; i < fanGroups.length; ++i) {
				System.out.println(fanGroups[i].getNewsgroup());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExtendedNNTPOps ops;

		if (args.length != 3) {
			System.err.println("usage: ExtendedNNTPOps nntpserver username password");
			System.exit(1);
		}

		ops = new ExtendedNNTPOps();
		ops.demo(args[0], args[1], args[2]);
	}

}

/* Emacs configuration
 * Local variables:        **
 * mode:             java  **
 * c-basic-offset:   4     **
 * indent-tabs-mode: nil   **
 * End:                    **
 */
