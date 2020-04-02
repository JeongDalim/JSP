package net.webmvc.controller.pds;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.webmvc.action.Action;
import net.webmvc.dao.PdsDAO;
import net.webmvc.dto.PdsVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Pds_Modify_ProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection conn = null;
		try {
			int idx = Integer.parseInt(request.getParameter("idx"));
			conn = DBConn.getConnection();
			PdsDAO dao = PdsDAO.getInstance();
			request.setCharacterEncoding("utf-8");
			// ���⸦ �ٲ��ָ� �ٿ�޴� ��ΰ� �ٲ�
			String savePath = "upload";
			// �ִ� ���ε� ���� 5mb�� ����
			int uploadFileSizeLimit = 5 * 1024 * 1024;
			String encType = "utf-8";
			ServletContext context = request.getSession().getServletContext();
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
					out.print("<br>name:" + multi.getParameter("name"));
					out.print("<br>subject:" + multi.getParameter("subject"));
					out.print("<br>file:" + fileName);
					String name = multi.getParameter("name");
					String pass = multi.getParameter("pass");
					String subject = multi.getParameter("subject");
					String contents = multi.getParameter("contents");
					PdsVO vo = new PdsVO();
					vo.setFilename(fileName);
					vo.setName(name);
					vo.setPass(pass);
					vo.setSubject(subject);
					vo.setContents(contents);
					dao.modify(conn, vo, idx);
					response.sendRedirect("PdsServlet?cmd=pds_list");
				}
			} catch (Exception e) {
				System.out.println("���͹߻�:" + e);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}
}
