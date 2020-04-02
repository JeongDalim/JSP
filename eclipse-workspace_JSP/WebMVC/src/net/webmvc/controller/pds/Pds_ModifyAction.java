package net.webmvc.controller.pds;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.PdsDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Pds_ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			int idx = Integer.parseInt(request.getParameter("idx"));
			conn = DBConn.getConnection();
			PdsDAO dao = PdsDAO.getInstance();
			request.setAttribute("vo", dao.view(conn, idx));
			RequestDispatcher rd = request.getRequestDispatcher("pds/pds_modify.jsp");
			rd.forward(request, response);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
}
