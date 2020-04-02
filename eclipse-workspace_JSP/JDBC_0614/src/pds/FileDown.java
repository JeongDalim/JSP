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
		String filename = request.getParameter("filename"); // 파일을 받는다
		String path = request.getRealPath("/") + "/upload";
		File file = new File(path + "/" + filename); // 절대경로
		String Agent = request.getHeader("USER-AGENT");
		response.setContentType("application/unknown"); // 파일형태
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		try {
			byte b[] = new byte[5 * 1024 * 1024]; // SM byte까지 업로드가 가능하므로 크기를 이렇게 잡아주었음
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