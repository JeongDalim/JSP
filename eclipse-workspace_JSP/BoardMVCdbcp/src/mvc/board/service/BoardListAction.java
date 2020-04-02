package mvc.board.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.dao.BoardDAO;
import mvc.board.dto.BoardVO;
import mvc.board.util.DBConn;
import mvc.board.util.DBUtil;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			String url = "BoardServlet?cmd=board_list";
			String addtag = "";

			// 검색조건 처리방법
			int nowpage = 1;
			int maxlist = 10; // 웹페이지당 글 수
			int totpage = 1;
			int totcount = dao.board_count(conn); // 총 글 수

			// 총페이지수 계산
			if (totcount % maxlist == 0) {
				totpage = totcount / maxlist;
			} else {
				totpage = totcount / maxlist + 1; //나우어 떨어지지 않을떄 
			}
			if (totpage == 0) //나눈게 0일떄 부족할떄 예) 9/10
				totpage = 1;

			if (request.getParameter("page") != null && !request.getParameter("page").equals("")) {
				nowpage = Integer.parseInt(request.getParameter("page"));
			}
			if (nowpage > totpage) { //
				nowpage = totpage;
			}

			int pagestart = (nowpage - 1) * maxlist;// 페이지 시작번호(0,10)
			int endpage = nowpage * maxlist;// 페이지 끝번호(10,20)
			int listcount = totcount - ((nowpage - 1) * maxlist) + 1;

			List<BoardVO> list = dao.board_list(conn, pagestart, endpage);

			request.setAttribute("totcount", totcount);
			request.setAttribute("addtag", addtag);
			request.setAttribute("url", url);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("totpage", totpage);
			request.setAttribute("listcount", listcount);
			request.setAttribute("list", list);
			// 페이지 스킵 처리
			String pageSkip = mvc.board.util.PageIndex.pageList(nowpage, totpage, url, addtag);
			request.setAttribute("pageSkip", pageSkip);
			conn = DBConn.getConnection();

			RequestDispatcher rd = request.getRequestDispatcher("Board/board_list.jsp");
			rd.forward(request, response);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

}
