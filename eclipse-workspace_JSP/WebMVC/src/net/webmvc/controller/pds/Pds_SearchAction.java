package net.webmvc.controller.pds;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.NoticeDAO;
import net.webmvc.dao.PdsDAO;
import net.webmvc.dto.PdsVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;
import net.webmvc.util.PageIndex;

public class Pds_SearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			PdsDAO dao = PdsDAO.getInstance();
			String url = "PdsServlet?cmd=pds_search";
			String search = request.getParameter("search");
			String key = request.getParameter("key");
			String addtag = "&search=" + search + "&key=" + key;
			String s_query = search + " like " + " '%" + key + "%'";

			// 검색조건 처리방법
			int nowpage = 1;
			int maxlist = 10; // 웹페이지당 글 수
			int totpage = 1;
			int totcount = dao.search_count(conn, search, key); // 총 글 수

			// 총페이지수 계산
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

			int pagestart = (nowpage - 1) * maxlist;// 페이지 시작번호(0,10)
			int endpage = nowpage * maxlist;// 페이지 끝번호(10,20)
			int listcount = totcount - ((nowpage - 1) * maxlist) + 1;

			List<PdsVO> list = dao.list_search(conn, s_query, pagestart, endpage);

			request.setAttribute("totcount", totcount);
			request.setAttribute("addtag", addtag);
			request.setAttribute("url", url);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("totpage", totpage);
			request.setAttribute("listcount", listcount);
			request.setAttribute("list", list);
			// 페이지 스킵 처리
			String pageSkip = PageIndex.pageList(nowpage, totpage, url, addtag);
			request.setAttribute("pageSkip", pageSkip);

			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("pds/pds_list.jsp");
			rd.forward(request, response);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

}
