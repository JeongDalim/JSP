package com.jslhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.BoardDAO;

@WebServlet("/board_modify.do")
public class BoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardModify() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        BoardDAO dao = BoardDAO.getInstance();
        request.setAttribute("bean",dao.BoardView(num));
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_modify.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
