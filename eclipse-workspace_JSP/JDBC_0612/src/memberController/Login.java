package memberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import memberBean.MemberBean;
import memberDAO.MemberDAO;

@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Member/userlogin_form.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		MemberDAO dao = MemberDAO.getInstance();

		MemberBean bean = dao.login(userid, passwd);

		if (bean != null) {
			HttpSession session = request.getSession();	
			session.setMaxInactiveInterval(1800);
			session.setAttribute("session", userid);
			request.setAttribute("bean", bean);
			RequestDispatcher rd = request.getRequestDispatcher("Member/userlogin_ok.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("Member/userlogin_fail.jsp");
		}
	}

}
