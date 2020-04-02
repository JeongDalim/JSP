package net.webmvc.controller.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.NoticeDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Notice_DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			int idx = Integer.parseInt(request.getParameter("idx"));
			conn = DBConn.getConnection();
			NoticeDAO dao = NoticeDAO.getInstance();
			dao.delete(conn, idx);
			response.sendRedirect("NoticeServlet?cmd=notice_list");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

}
