package mvc.board.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.dao.BoardDAO;
import mvc.board.util.DBConn;
import mvc.board.util.DBUtil;

public class BoardDelete_proAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();

			int num = Integer.parseInt(request.getParameter("num"));
			int nowpage = Integer.parseInt(request.getParameter("page"));
			String pass = request.getParameter("pass");

			BoardDAO dao = BoardDAO.getInstance();

			int row = dao.board_delete(conn, num, pass);
			request.setAttribute("row", row);
			request.setAttribute("nowpage", nowpage);
			response.sendRedirect("BoardServlet?cmd=board_list");

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

}
