
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test2.do")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Test2() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String h = request.getParameter("h");
		String str = (String)session.getAttribute("session");
		System.out.println(h);
		System.out.println(str);
		
		request.setAttribute("h", h);
		request.setAttribute("session",str);
		RequestDispatcher rd = request.getRequestDispatcher("Test3.jsp");
		rd.forward(request, response);
	
	}

}
