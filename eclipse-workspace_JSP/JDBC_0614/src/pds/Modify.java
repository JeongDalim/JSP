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
		// ���⸦ �ٲ��ָ� �ٿ�޴� ��ΰ� �ٲ�
		String savePath = "upload";
		// �ִ� ���ε� ���� 5mb�� ����
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "utf-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("�������� ���� ���丮:");
		System.out.println(uploadFilePath);
		try {
			MultipartRequest multi = new MultipartRequest(request, // ��ü
					uploadFilePath, // �������� ���� ���丮
					uploadFileSizeLimit, // �ִ� ���ε� ���� ũ��
					encType, // ���ڵ����
					new DefaultFileRenamePolicy());// ������ �̸��� �����ϸ� ���ο� �̸��� �ο���
			String fileName = multi.getFilesystemName("filename");// ���ε�� ������ �̸� ���
			if (fileName == null) { // ������ ���ε� ���� �ʾ��� ��
				System.out.println("������ ���ε���� �ʾ���");
			} else { // ������ ���ε� �Ǿ��� ��
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
			System.out.println("���͹߻�:" + e);
		}
	}
}
