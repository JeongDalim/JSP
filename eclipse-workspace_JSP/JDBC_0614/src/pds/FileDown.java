package pds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filedown.do")
public class FileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileDown() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("filename"); // ������ �޴´�
		String path = request.getRealPath("/") + "/upload";
		File file = new File(path + "/" + filename); // ������
		String Agent = request.getHeader("USER-AGENT");
		response.setContentType("application/unknown"); // ��������
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		try {
			byte b[] = new byte[5 * 1024 * 1024]; // SM byte���� ���ε尡 �����ϹǷ� ũ�⸦ �̷��� ����־���
			if (file.isFile()) {
				BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
				try {
					int read = 0;
					while ((read = fin.read(b)) != -1) {
						outs.write(b, 0, read);
					}
					outs.flush();
					outs.close();
					fin.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IllegalStateException se) {
			se.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}