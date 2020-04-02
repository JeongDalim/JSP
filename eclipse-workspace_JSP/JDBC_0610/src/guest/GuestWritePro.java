package guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guest_write_pro.do")
public class GuestWritePro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestWritePro() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");

		GuestBean bean = new GuestBean();
		bean.setName(name);
		bean.setSubject(subject);
		bean.setContents(contents);
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.GuestInsert(bean);

		request.setAttribute("row", row);
		response.sendRedirect("Guest/guest_list.jsp");

	}

}
