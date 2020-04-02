
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test.do")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		HttpSession session = request.getSession(); // 技记 积己
		session.setMaxInactiveInterval(1800); // 技记 蜡瓤矫埃 瘤沥
		if (session != null) {
			System.out.println("技记 积己 己傍");
		}
		
		String dalimAge = "26";
		session.setAttribute("session",dalimAge);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Test2.jsp");
		rd.forward(request, response);
	}

}
