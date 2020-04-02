package mvc.board.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.dao.BoardDAO;
import mvc.board.dto.BoardVO;
import mvc.board.util.DBConn;
import mvc.board.util.DBUtil;

public class BoardEditAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();

			int num = Integer.parseInt(request.getParameter("num"));
			int nowpage = Integer.parseInt(request.getParameter("page"));
			BoardDAO dao = BoardDAO.getInstance();
			BoardVO vo = dao.board_view(conn, num);

			request.setAttribute("vo", vo);
			request.setAttribute("nowpage", nowpage);
			RequestDispatcher dispater = request.getRequestDispatcher("Board/board_modify.jsp");
			dispater.forward(request, response);

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

}
