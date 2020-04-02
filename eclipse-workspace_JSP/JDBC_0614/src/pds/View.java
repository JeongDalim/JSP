package pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pds2.PdsBean;
import pds2.PdsDAO;

@WebServlet("/view.do")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public View() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(1800);
		session.setAttribute("session", num);
		PdsDAO dao = PdsDAO.getInstance();
		PdsBean bean = dao.view(num);
		Cookie[] cookies = request.getCookies();
		boolean sw = true;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("view" + num)) {
				if (cookies[i].getValue().equals(num + "")) {
					sw = false;
				}
			}
		}
		if (sw) {
			Cookie cookie = new Cookie("view" + num, num + "");
			cookie.setMaxAge(30);
			dao.hits(bean);
			int hit = bean.getReadcnt();
			bean.setReadcnt(++hit);
			response.addCookie(cookie);
		}
		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_view.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
