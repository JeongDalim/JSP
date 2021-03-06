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

public class Board_Write_ProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			String name = request.getParameter("name");
			String subject = request.getParameter("subject");
			String contents = request.getParameter("contents");
			String pass = request.getParameter("pass");
			BoardVO vo = new BoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContents(contents);
			vo.setPass(pass);
			dao.write(conn, vo);
			response.sendRedirect("BoardServlet?cmd=board_list");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

}
