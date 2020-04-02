package JDBC_0614.pds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload2.do")
public class Upload2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Upload2() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("input2.jsp");
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
					new DefaultFileRenamePolicy());// ������ �̸��� �����ϸ� ���ο� �̸��� �ο�000000��
			Enumeration<?> files = multi.getFileNames();
			while (files.hasMoreElements()) {
				String file = (String) files.nextElement();// ���ε�� ������ �̸� ���
				String file_name = multi.getOriginalFileName(file);
				String ori_file_name = multi.getOriginalFileName(file);
				out.print("<br>file:" + file_name);
				out.print("<br>ori_file:" + ori_file_name);
			}

		} catch (Exception e) {
			System.out.println("���͹߻�:" + e);
		}

	}

}
