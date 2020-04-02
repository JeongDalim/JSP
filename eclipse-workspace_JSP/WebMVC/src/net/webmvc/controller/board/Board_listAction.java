package net.webmvc.controller.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.BoardDAO;
import net.webmvc.dto.BoardVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;
import net.webmvc.util.PageIndex;

public class Board_listAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			String url = "BoardServlet?cmd=board_list";
			String addtag = "";

			// �˻����� ó�����
			int nowpage = 1;
			int maxlist = 10; // ���������� �� ��
			int totpage = 1;
			int totcount = dao.count(conn); // �� �� ��

			// ���������� ���
			if (totcount % maxlist == 0) {
				totpage = totcount / maxlist;
			} else {
				totpage = totcount / maxlist + 1;
			}
			if (totpage == 0)
				totpage = 1;

			if (request.getParameter("page") != null && !request.getParameter("page").equals("")) {
				nowpage = Integer.parseInt(request.getParameter("page"));
			}
			if (nowpage > totpage) {
				nowpage = totpage;
			}

			int pagestart = (nowpage - 1) * maxlist;// ������ ���۹�ȣ(0,10)
			int endpage = nowpage * maxlist;// ������ ����ȣ(10,20)
			int listcount = totcount - ((nowpage - 1) * maxlist) + 1;

			List<BoardVO> list = dao.list(conn, pagestart, endpage);

			request.setAttribute("totcount", totcount);
			request.setAttribute("addtag", addtag);
			request.setAttribute("url", url);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("totpage", totpage);
			request.setAttribute("listcount", listcount);
			request.setAttribute("list", list);
			// ������ ��ŵ ó��
			String pageSkip = PageIndex.pageList(nowpage, totpage, url, addtag);
			request.setAttribute("pageSkip", pageSkip);

			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("board/board_list.jsp");
			rd.forward(request, response);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
}
