package org.g4studio.core.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.g4studio.core.model.SpringBeanLoader;
import org.g4studio.core.properties.PropertiesFactory;
import org.g4studio.core.properties.PropertiesFile;
import org.g4studio.core.properties.PropertiesHelper;
import org.g4studio.core.util.G4Constants;
import org.g4studio.system.common.util.SystemConstants;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * G4Server服务器,基于Jetty构建<br>
 * 使用G4Server将大大提高应用启动速度,并能有效解决在开发过程中classes不同步的问题
 * @author XiongChun
 * @since 2009-07-22
 */
public class G4Server {
	
	private static Log log = LogFactory.getLog(G4Server.class);
	
	/**
	 * Web应用上下文
	 */
	private String webContext;
	/**
	 * Web端口
	 */
	private int webPort;
	/**
	 * Web物理磁盘根路径
	 */
	private String WebApp;
	
	Server server = null;
	
	public G4Server(){
		server = new Server();
	}
	
	/**
	 * G4Server构造函数
	 * @param pWebContext Web应用上下文
	 * @param pWebPor Web端口
	 */
	public G4Server(String pWebApp, String pWebContext, int pWebPort){
		server = new Server();
		this.webContext = pWebContext;
		this.webPort = pWebPort;
		this.WebApp = pWebApp;
	}
	
	/**
	 * 启动G4Server
	 */
	public void start(){
	    PropertiesHelper pHelper = PropertiesFactory.getPropertiesHelper(PropertiesFile.G4);
	    String forceLoad = pHelper.getValue("forceLoad", SystemConstants.FORCELOAD_N);
		/**
		 * 强制改变加载顺序
		 * 解决直接使用iBatis源码带来的初始化Spring容器报错的问题
		 */
	    if(forceLoad.equals(SystemConstants.FORCELOAD_Y)){
		    log.info("********************************************");
		    log.info("G4系统集成与应用开发平台[G4Studio]开始启动...");
		    log.info("********************************************");
		    log.info("系统正在初始化服务容器...");
		    SpringBeanLoader.getApplicationContext();
		    log.info("容器初始化成功啦，您的托管Bean已经被实例化。");
		}
		
		Connector connector = new SelectChannelConnector();
		connector.setPort(webPort);
		server.setConnectors(new Connector[] { connector });
		WebAppContext context = new WebAppContext(
				server,
				WebApp,
				webContext);
		try {
			server.start();
		} catch (Exception e) {
			log.error(G4Constants.Exception_Head + "\n G4Server启动出错.\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * 停止G4Server
	 */
	public void stop() {
		try {
			server.stop();
		} catch (Exception e) {
			log.error(G4Constants.Exception_Head + "\n G4Server未能正常停止.\n");
			e.printStackTrace();
		}
	}

	public String getWebContext() {
		return webContext;
	}

	public void setWebContext(String webContext) {
		this.webContext = webContext;
	}

	public int getWebPort() {
		return webPort;
	}

	public void setWebPort(int webPort) {
		this.webPort = webPort;
	}

	public String getWebApp() {
		return WebApp;
	}

	public void setWebApp(String webApp) {
		WebApp = webApp;
	}
	
}
