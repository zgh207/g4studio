package org.g4studio.demo.web.other.applet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CatalogServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// PrintWriter out=response.getWriter();
		byte[] buff = new byte[10240];
		FileInputStream infile = null;
		ServletOutputStream fos = null;

		//String filePath = (String) req.getParameter("filePath");
		File fe = new File("E:/G4/svn/web/WebRoot/demo/test/01.rar");
		try {
			infile = new FileInputStream(fe);
			fos = res.getOutputStream();
		} catch (FileNotFoundException e) {
			System.err.println("没有找到文件");
			System.exit(1);
		}

		int n = infile.read(buff);
		while (n != -1) {
			try {
				// 从文件读取数据
				fos.write(buff, 0, n); // 写入System.out中
				n = infile.read(buff);

			} catch (Exception e) {
				System.out.println("写入流失败！");
				e.printStackTrace();
			}
		}
		System.out.println("写入流成功！");

		try {
			infile.close();
			fos.close();
		} catch (IOException e) {
			System.err.println("文件错误");
			System.exit(1);
		}
	}
}
