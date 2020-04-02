package net.webmvc.controller.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.NoticeDAO;
import net.webmvc.dto.NoticeVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Notice_Write_ProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			NoticeDAO dao = NoticeDAO.getInstance();
			String subject = request.getParameter("subject");
			String contents = request.getParameter("contents");
			NoticeVO vo = new NoticeVO();
			vo.setSubject(subject);
			vo.setContents(contents);
			dao.write(conn, vo);
			response.sendRedirect("NoticeServlet?cmd=notice_list");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
}
