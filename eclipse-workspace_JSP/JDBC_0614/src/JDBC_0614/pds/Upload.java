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
			String fileName = multi.getFilesystemName("upfile");// ���ε�� ������ �̸� ���
			if (fileName == null) { // ������ ���ε� ���� �ʾ��� ��
				System.out.println("������ ���ε���� �ʾ���");
			} else { // ������ ���ε� �Ǿ��� ��
				out.print("<br>name:" + multi.getParameter("name"));
				out.print("<br>subject:" + multi.getParameter("subject"));
				out.print("<br>file:" + fileName);
			}

		} catch (Exception e) {
			System.out.println("���͹߻�:" + e);
		}

	}

}
