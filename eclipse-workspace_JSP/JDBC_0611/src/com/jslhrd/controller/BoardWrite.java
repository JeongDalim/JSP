package com.jslhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.bean.BoardBean;
import com.jslhrd.dao.BoardDAO;

@WebServlet("/board_write.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardWrite() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_write.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		BoardBean bean = new BoardBean();
		bean.setName(name);
		bean.setPass(pass);
		bean.setEmail(email);
		bean.setSubject(subject);
		bean.setContents(contents);
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardWrite(bean);
		RequestDispatcher rd = request.getRequestDispatcher("board_list.do");
		rd.forward(request, response);
	}

}
