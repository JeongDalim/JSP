package net.webmvc.controller.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.BoardDAO;
import net.webmvc.dto.BoardVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Board_Modify_ProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			int idx = Integer.parseInt(request.getParameter("idx"));
			String subject = request.getParameter("subject");
			String contents = request.getParameter("contents");

			BoardVO vo = new BoardVO();

			vo.setSubject(subject);
			vo.setContents(contents);

			BoardDAO dao = BoardDAO.getInstance();

			dao.modify(conn, vo, idx);
			response.sendRedirect("BoardServlet?cmd=board_list");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

}
