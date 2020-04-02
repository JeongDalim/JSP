package net.webmvc.controller.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.NoticeDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Notice_listAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			NoticeDAO dao = NoticeDAO.getInstance();
			request.setAttribute("list", dao.list(conn));
			RequestDispatcher rd = request.getRequestDispatcher("notice/notice_list.jsp");
			rd.forward(request, response);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
}
