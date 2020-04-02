package memberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberBean.MemberBean;
import memberDAO.MemberDAO;

@WebServlet("/modify.do")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Modify() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		MemberDAO dao = MemberDAO.getInstance();
		MemberBean bean = dao.mb(userid);
		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("Member/userinfo_modify.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String zipcode=request.getParameter("zipcode");
		String addr1= request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String [] fa = request.getParameterValues("fa");
		String favorite = fa[0];
		for(int i=1; i<fa.length; i++) {
			favorite+=","+fa[i];
		}
		String job = request.getParameter("job");
		String intro = request.getParameter("intro");
		
		MemberBean bean = new MemberBean();
		
		bean.setUserid(userid);
		bean.setPasswd(passwd);
		bean.setName(name);
		bean.setZipcode(zipcode);
		bean.setAddr1(addr1);
		bean.setAddr2(addr2);
		bean.setTel(tel);
		bean.setEmail(email);
		bean.setFavorite(favorite);
		bean.setJob(job);	
		bean.setIntro(intro);
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.modify(bean);
		response.sendRedirect("list.do");
	}

}
