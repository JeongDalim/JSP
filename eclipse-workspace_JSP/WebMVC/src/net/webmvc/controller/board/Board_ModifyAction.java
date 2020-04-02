package net.webmvc.controller.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.BoardDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Board_ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			int idx = Integer.parseInt(request.getParameter("idx"));
			request.setAttribute("vo", dao.view(conn, idx));
			RequestDispatcher rd = request.getRequestDispatcher("board/board_modify.jsp");
			rd.forward(request, response);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}
}
