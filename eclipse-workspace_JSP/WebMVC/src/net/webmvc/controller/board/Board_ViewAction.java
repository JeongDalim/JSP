package net.webmvc.controller.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.BoardDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;
import net.webmvc.util.SqlMark;

public class Board_ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			int idx = Integer.parseInt(request.getParameter("idx"));
			BoardDAO dao = BoardDAO.getInstance();
			request.setAttribute("vo", dao.view(conn, idx));
			String newValue = System.currentTimeMillis() + "";
			Cookie[] cookies = request.getCookies();
			boolean sw = true;
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(idx + "")) {
					sw = false;
				}
			}

			if (sw) {
				dao.hits(conn, idx);
				Cookie cookie = new Cookie(idx + "", newValue);
				cookie.setMaxAge(30);
				response.addCookie(cookie);

			}

			request.setAttribute("contents", SqlMark.lineBreak(dao.view(conn, idx).getContents()));
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			DBUtil.close(conn);
		}
		RequestDispatcher rd = request.getRequestDispatcher("board/board_view.jsp");
		rd.forward(request, response);
	}
}
