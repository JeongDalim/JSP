package JDBC_0614.pds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("input.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 여기를 바꿔주면 다운받는 경로가 바뀜
		String savePath = "upload";
		// 최대 업로드 파일 5mb로 제한
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "utf-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리:");
		System.out.println(uploadFilePath);

		try {
			MultipartRequest multi = new MultipartRequest(request, // 객체
					uploadFilePath, // 서버상의 실제 디렉토리
					uploadFileSizeLimit, // 최대 업로드 파일 크기
					encType, // 인코딩방법
					new DefaultFileRenamePolicy());// 동일한 이름이 존재하면 새로운 이름이 부여됨
			String fileName = multi.getFilesystemName("upfile");// 업로드된 파일의 이름 얻기
			if (fileName == null) { // 파일이 업로드 되지 않았을 때
				System.out.println("파일이 업로드되지 않았음");
			} else { // 파일이 업로드 되었을 때
				out.print("<br>name:" + multi.getParameter("name"));
				out.print("<br>subject:" + multi.getParameter("subject"));
				out.print("<br>file:" + fileName);
			}

		} catch (Exception e) {
			System.out.println("예와발생:" + e);
		}

	}

}
