package memberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberDAO.MemberDAO;


@WebServlet("/postCheck.do")
public class PostCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PostCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Member/post_check.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String addr=request.getParameter("addr");
		MemberDAO dao = MemberDAO.getInstance();
		request.setAttribute("list",dao.ZipList(addr));
		RequestDispatcher rd = request.getRequestDispatcher("Member/post_check.jsp");
		rd.forward(request, response);
	}
}
