package mvc.board.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.util.DBConn;
import mvc.board.util.DBUtil;



public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
		
		int nowpage = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("nowpage", nowpage);
		
		RequestDispatcher dispater = request.getRequestDispatcher("Board/board_write.jsp");
		dispater.forward(request, response);
	
		
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

}
