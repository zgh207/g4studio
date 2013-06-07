package org.g4studio.core.ftp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.g4studio.core.exception.NullAbleException;
import org.g4studio.core.net.ftp.FTP;
import org.g4studio.core.net.ftp.FTPClient;
import org.g4studio.core.net.ftp.FTPFile;
import org.g4studio.core.net.ftp.FTPReply;
import org.g4studio.core.util.G4Constants;
import org.g4studio.core.util.G4Utils;

/**
 * 基于FTP协议的文件处理支持类<br>
 * 
 * @author XiongChun
 * @since 2011-05-27
 */
public class FtpHelper {

	private static Log log = LogFactory.getLog(FtpHelper.class);
	private String host;
	private String username;
	private String password;
	private int portno = 21;
	private FTPClient ftpClient = null;

	public FtpHelper() {

	}

	/**
	 * 创建FTP连接
	 * 
	 * @param host
	 *            远程主机
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param portno
	 *            端口号
	 * @return
	 */
	public boolean createConnection(String host, String username, String password, int portno) {
		setHost(host);
		setPassword(password);
		setUsername(username);
		setPassword(password);
		ftpClient = new FTPClient();
		try {
			ftpClient.connect(host, portno);
			// 此处设置无效, 直接修改了ftp.java文件
			//ftpClient.setControlEncoding("utf-8");
			if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				if (ftpClient.login(username, password)) {
					if (log.isInfoEnabled()) {
						ftpClient.enterLocalPassiveMode();
						log.info("和远程FTP主机[" + host + "]连接成功.\n" + ftpClient.getReplyString());
					}
					return true;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (log.isErrorEnabled()) {
			log.error("和远程FTP主机[" + host + "]连接失败.\n" + ftpClient.getReplyString());
		}
		disconnect();
		return false;
	}

	/**
	 * 断开连接
	 * 
	 * @throws IOException
	 */
	public void disconnect() {
		if (ftpClient != null) {
			try {
				ftpClient.logout();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (log.isInfoEnabled()) {
				log.info("退出FTP远程主机![" + host + "]" + ftpClient.getReplyString());
			}
		}
		if (ftpClient.isConnected()) {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 使用当前工作路径(支持递归创建工作目录)
	 * 
	 * @param dir
	 *            要使用的工作路径,格式:/a/b/c/d
	 * @return
	 */
	public boolean useWorkingDir(String dir) {
		if (G4Utils.isEmpty(dir)) {
			throw new NullAbleException();
		}
		if (G4Utils.isEmpty(ftpClient)) {
			throw new NullAbleException();
		}
		if (dir.equals("/")) {
			try {
				boolean status = ftpClient.changeWorkingDirectory(dir);
				if (log.isDebugEnabled()) {
					log.debug(ftpClient.getReplyString());
				}
				if (log.isInfoEnabled()) {
					log.info("远程FTP工作目录切换到:" + dir);
				}
				return status;
			} catch (IOException e) {
				if (log.isErrorEnabled()) {
					log.error(G4Constants.Exception_Head + "远程FTP工作目录切换发生异常");
				}
				e.printStackTrace();
			}

		}
		String[] dirs = dir.substring(1).split("/");
		for (int i = 0; i < dirs.length; i++) {
			dirs[i] = "/" + dirs[i];
		}
		String path = "";
		try {
			for (int i = 0; i < dirs.length; i++) {
				path = path + dirs[i];
				if (!ftpClient.changeWorkingDirectory(path)) {
					if (ftpClient.makeDirectory(path)) {
						ftpClient.changeWorkingDirectory(path);
					} else {
						if (log.isErrorEnabled()) {
							log.error(G4Constants.Exception_Head + "创建远程FTP工作目录发生异常");
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (log.isDebugEnabled()) {
			log.debug("远程FTP目录切换到:" + path);
		}
		return true;
	}

	/**
	 * FTP文件上传
	 * 
	 * @param fis
	 *            文件流对象
	 * @param filename
	 *            远程存储的文件名
	 * @return
	 */
	public boolean storeFile(InputStream fis, String filename) {
		boolean status = true;
		if (G4Utils.isEmpty(ftpClient)) {
			if (log.isErrorEnabled()) {
				log.error(G4Constants.Exception_Head + "");
			}
			return false;
		}
		try {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			status = ftpClient.storeFile(filename, fis);
			if (log.isInfoEnabled()) {
				log.info("文件上传成功." + ftpClient.getReplyString());
			}
		} catch (IOException e) {
			if (log.isErrorEnabled()) {
				log.error(G4Constants.Exception_Head + "文件上传失败");
			}
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return status;
	}

	/**
	 * 文件上传
	 * 
	 * @param localFilePath
	 *            本地文件物理绝对路径
	 * @param filename
	 *            远程文件名
	 * @return
	 */
	public boolean storeFile(String localFilePath, String filename) {
		boolean status = true;
		if (G4Utils.isEmpty(ftpClient)) {
			if (log.isErrorEnabled()) {
				log.error(G4Constants.Exception_Head + "");
			}
			return false;
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(localFilePath);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			status = ftpClient.storeFile(filename, fis);
			if (log.isInfoEnabled()) {
				log.info("文件上传成功." + ftpClient.getReplyString());
			}
		} catch (IOException e) {
			if (log.isErrorEnabled()) {
				log.error(G4Constants.Exception_Head + "文件上传失败");
			}
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return status;
	}

	/**
	 * 删除远程文件
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean removeFile(String fullPathFileName) {
		boolean success = false;
		String workingPath = fullPathFileName.substring(0, fullPathFileName.lastIndexOf("/"));
		String filename = fullPathFileName.substring(fullPathFileName.lastIndexOf("/") + 1,
				fullPathFileName.length());
		try {
			if (ftpClient.changeWorkingDirectory(workingPath)) {
				success = ftpClient.deleteFile(filename);
				if (success) {
					if (log.isInfoEnabled()) {
						log.info("删除文件[" + fullPathFileName + "]成功 " + ftpClient.getReplyString());
					}
				} else {
					if (log.isErrorEnabled()) {
						log.error(G4Constants.Exception_Head + "删除文件[" + fullPathFileName
								+ "]失败");
					}
				}
			} else {
				if (log.isErrorEnabled()) {
					log.error(G4Constants.Exception_Head + "切换工作目录[" + workingPath + "]失败");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 删除远程路径
	 * 
	 * @param fileName
	 *            路径名称
	 * @return
	 */
	public boolean removeDir(String dirName) {
		boolean success = false;
		try {
			FTPFile[] files = ftpClient.listFiles(dirName);
			for (int i = 0; i < files.length; i++) {
				if (!files[i].getName().equals(".") && !files[i].getName().equals("..")) {
					if (files[i].isDirectory()) {
						log.error(G4Constants.Exception_Head + "删除目录[" + dirName
								+ "]失败,此路径下嵌套有子目录.");
						return false;
					}
				}
			}
			// ftpClient.changeWorkingDirectory(dirName);
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					ftpClient.deleteFile(dirName + "/" + files[i].getName());
				}
			}
			success = ftpClient.removeDirectory(dirName);

			if (success && log.isInfoEnabled()) {
				log.info("目录删除成功" + ftpClient.getReplyString());
			} else {
				if (log.isErrorEnabled()) {
					log.error(G4Constants.Exception_Head + "删除目录[" + dirName + "]失败");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 下载文件
	 * 
	 * @param localFile
	 *            本地存储文件全路径,如:c:/beauty.jpg
	 * @param remoteFile
	 *            远程FTP路径,如:/b/a/beauty.jpg
	 * @return
	 */
	public boolean getFile(String localFile, String remoteFile) {
		boolean success = false;
		OutputStream output = null;
		try {
			output = new FileOutputStream(localFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			success = ftpClient.retrieveFile(remoteFile, output);
			if (success) {
				log.info("下载文件[" + remoteFile + "]成功, 被存储到[" + localFile + "]");
			}else {
				log.error(G4Constants.Exception_Head + "下载文件[" + remoteFile + "]失败");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPortno() {
		return portno;
	}

	public void setPortno(int portno) {
		this.portno = portno;
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}
}
