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

@WebServlet("/board_modify_pro.do")
public class BoardModifyPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardModifyPro() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    int num = Integer.parseInt(request.getParameter("num"));
	        String email = request.getParameter("email");
	        String subject = request.getParameter("subject");
	        String contents = request.getParameter("contents");
	        BoardDAO dao = BoardDAO.getInstance();
	        BoardBean bean = new BoardBean();
	        bean.setNum(num);
	        bean.setEmail(email);
	        bean.setSubject(subject);
	        bean.setContents(contents);
	        dao.BoardModify(bean);
			RequestDispatcher rd = request.getRequestDispatcher("board_list.do");
			rd.forward(request, response);
	}

}
