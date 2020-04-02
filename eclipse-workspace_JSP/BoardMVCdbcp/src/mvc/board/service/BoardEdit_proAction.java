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

public class BoardEdit_proAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();

			request.setCharacterEncoding("utf-8");
			int num = Integer.parseInt(request.getParameter("num"));
			int nowpage = Integer.parseInt(request.getParameter("page"));
			String name = request.getParameter("name");
			String subject = request.getParameter("subject");
			String contents = request.getParameter("contents");
			String pass = request.getParameter("pass");
			String email = request.getParameter("email");

			BoardVO vo = new BoardVO();
			vo.setNum(num);
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContents(contents);
			vo.setEmail(email);
			vo.setPass(pass);

			BoardDAO dao = BoardDAO.getInstance();
			int row = dao.board_modify(conn, vo, pass);
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
