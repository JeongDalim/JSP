package net.webmvc.controller.pds;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.PdsDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Pds_DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			int idx = Integer.parseInt(request.getParameter("idx"));
			conn = DBConn.getConnection();
			PdsDAO dao = PdsDAO.getInstance();
			dao.delete(conn, idx);

			response.sendRedirect("PdsServlet?cmd=pds_list");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
}
