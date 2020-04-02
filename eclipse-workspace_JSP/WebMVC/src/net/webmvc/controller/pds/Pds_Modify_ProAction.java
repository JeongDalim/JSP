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
			// 여기를 바꿔주면 다운받는 경로가 바뀜
			String savePath = "upload";
			// 최대 업로드 파일 5mb로 제한
			int uploadFileSizeLimit = 5 * 1024 * 1024;
			String encType = "utf-8";
			ServletContext context = request.getSession().getServletContext();
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
				System.out.println("예와발생:" + e);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}
}
