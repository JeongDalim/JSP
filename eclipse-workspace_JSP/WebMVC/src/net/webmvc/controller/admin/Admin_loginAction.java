package net.webmvc.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.AdminDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class Admin_loginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection conn = null;
		try {
			conn = DBConn.getConnection();

			String adminid = request.getParameter("adminid");
			String adminpass = request.getParameter("adminpass");

			AdminDAO dao = AdminDAO.getInstance();
			if (dao.login(adminid, adminpass, conn) == true) {
				response.sendRedirect("AdminServlet?cmd=admin_main");
			} else {
				out.print("<script>alert('ID or PASSWORD is not correct!'); history.back();</script>");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

}
