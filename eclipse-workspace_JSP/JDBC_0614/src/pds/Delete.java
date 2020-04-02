package pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pds2.PdsDAO;

@WebServlet("/delete.do")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_delete.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pass = request.getParameter("pass");
		PdsDAO dao = PdsDAO.getInstance();
		if (dao.delete(pass) == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_delete_fail.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("list.do");
		}
	}

}
