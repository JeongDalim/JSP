package pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pds2.PdsBean;
import pds2.PdsDAO;

@WebServlet("/modify.do")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Modify() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int num = (int) session.getAttribute("session");
		PdsDAO dao = PdsDAO.getInstance();
		request.setAttribute("bean", dao.view(num));
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_modify.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int num = (int) session.getAttribute("session");
		session.invalidate();
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
			String fileName = multi.getFilesystemName("filename");// 업로드된 파일의 이름 얻기
			if (fileName == null) { // 파일이 업로드 되지 않았을 때
				System.out.println("파일이 업로드되지 않았음");
			} else { // 파일이 업로드 되었을 때
				String name = multi.getParameter("name");
				String subject = multi.getParameter("subject");
				String email = multi.getParameter("email");
				String contents = multi.getParameter("contents");
				String pass = multi.getParameter("pass");

				PdsBean bean = new PdsBean();

				bean.setNum(num);
				bean.setName(name);
				bean.setSubject(subject);
				bean.setPass(pass);
				bean.setContents(contents);
				bean.setFilename(fileName);
				bean.setEmail(email);

				PdsDAO dao = PdsDAO.getInstance();
				dao.modify(bean);
				response.sendRedirect("list.do");
			}
		} catch (Exception e) {
			System.out.println("예와발생:" + e);
		}
	}
}
