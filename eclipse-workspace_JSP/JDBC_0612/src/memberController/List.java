package memberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberDAO.MemberDAO;

@WebServlet("/list.do")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public List() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		request.setAttribute("list", dao.list());
		RequestDispatcher rd = request.getRequestDispatcher("Member/userinfo_list.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
