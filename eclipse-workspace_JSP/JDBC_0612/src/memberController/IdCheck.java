package memberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberDAO.MemberDAO;

@WebServlet("/idCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid="";
		if(request.getParameter("userid")!=null) {
		userid=request.getParameter("userid");	
		}		
		request.setAttribute("userid", userid);
		RequestDispatcher rd = request.getRequestDispatcher("Member/id_check.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid=request.getParameter("userid");
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.memberIdCheck(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Member/id_check.jsp");
		rd.forward(request, response);
	}

}
