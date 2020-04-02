package pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pds2.PdsDAO;

@WebServlet("/list.do")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public List() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PdsDAO dao = PdsDAO.getInstance();
		request.setAttribute("list", dao.list());
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_list.jsp");
		rd.forward(request, response);
	}
}
