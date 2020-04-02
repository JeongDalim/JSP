package net.webmvc.controller.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.BoardDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Board_DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			int idx = Integer.parseInt(request.getParameter("idx"));
			dao.delete(conn, idx);
			response.sendRedirect("BoardServlet?cmd=board_list");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
}
