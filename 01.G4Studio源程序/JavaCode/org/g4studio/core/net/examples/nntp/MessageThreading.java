package org.g4studio.core.net.examples.nntp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;

import org.g4studio.core.net.examples.PrintCommandListener;
import org.g4studio.core.net.nntp.Article;
import org.g4studio.core.net.nntp.NNTPClient;
import org.g4studio.core.net.nntp.NewsgroupInfo;
import org.g4studio.core.net.nntp.Threader;

public class MessageThreading {
	public MessageThreading() {
	}
	
	public static void main(String[] args) throws SocketException, IOException {
		
		if (args.length != 3)
			usage();
		
		String hostname = args[0];
		String user = args[1];
		String password = args[2];
		
		NNTPClient client = new NNTPClient();
		client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		client.connect(hostname);
		
		if(!client.authenticate(user, password)) {
			System.out.println("Authentication failed for user " + user + "!");
			System.exit(1);
		}
		
		NewsgroupInfo group = new NewsgroupInfo();
		client.selectNewsgroup("comp.lang.lisp", group);
		
		int lowArticleNumber = group.getFirstArticle();
		int highArticleNumber = lowArticleNumber + 100;
		
		System.out.println("Retrieving articles between [" + lowArticleNumber + "] and [" + highArticleNumber + "]");
		Article[] articles = NNTPUtils.getArticleInfo(client, lowArticleNumber, highArticleNumber);
		
		System.out.println("Building message thread tree...");
		Threader threader = new Threader();
		Article root = (Article)threader.thread(articles);
		
		Article.printThread(root, 0);	
		
	}
	
	
	public static void usage() {
		System.out.println("Usage: MessageThreading <hostname> <user> <password>");
		System.exit(0);
	}
}
