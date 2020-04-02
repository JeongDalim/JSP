package net.webmvc.controller.pds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.controller.pds.PdsActionFactory;

@WebServlet("/PdsServlet")
public class PdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PdsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println("test: " + cmd);
		Action action = null;
		PdsActionFactory af = PdsActionFactory.getInstance();
		action = af.getAction(cmd);
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
