package org.g4studio.core.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;
import org.g4studio.core.util.G4Utils;

/**
 * Log4J初始化
 * 
 * @author XiongChun
 * @since 2011-04-26
 */
public class Log4jInitServlet extends HttpServlet {

	/**
	 * Servlet初始化
	 */
	public void init(ServletConfig config) throws ServletException {
		String root = config.getServletContext().getRealPath("/");
		String log4jLocation = G4Utils.getFullPathRelateClass("../../../../../log4j.properties", getClass());
		System.setProperty("webRoot", root);
		if (G4Utils.isNotEmpty(log4jLocation)) {
			PropertyConfigurator.configure(log4jLocation);
		}
	}
}
