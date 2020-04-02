package mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mvc.board.dto.BoardVO;
import mvc.board.util.DBUtil;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	// 전체 글수 카운트
	public int board_count(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) from board";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
		return row;
	}

	// 전체 글수 카운트-검색
	public int board_count(Connection conn, String search, String key) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select * from board where rownum<10 and " + search + " like '%" + key + "%'";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
		return row;
	}

	// 페이지 리스트
	public List<BoardVO> board_list(Connection conn, int pagestart, int endpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select num, name, subject, indate, readcnt from(select rownum rn, num, name, subject, indate, readcnt from board where rownum <= ? order by num desc) where rn > ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setIndate(rs.getString("indate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
		return list;
	}

	// 게시글 전체 목록 구하기 - 검색 조건 포함
	public List<BoardVO> board_list(Connection conn, String s_query, int pagestart, int endpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select num,name,subject,indate,readcnt,contents from "
				+ "(select rownum rn,num,name,subject,indate,readcnt,contents from board where " + s_query
				+ " and rownum<= ? " + "order by num desc) where " + s_query + " and rn > ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			BoardVO board = null;
			while (rs.next()) {
				board = new BoardVO();
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setIndate(rs.getString("indate"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setContents(rs.getString("contents"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
		return list;
	}

	// 등록 메소드
	public int board_insert(Connection conn, BoardVO board) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "insert into board(num, name, pass, email, subject, contents, readcnt) values(board_num.nextval, ?, ?, ?, ?, ?, 0)";
		int row = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getPass());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getSubject());
			pstmt.setString(5, board.getContents());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
		return row;
	}

	// 수정 메소드
	public int board_modify(Connection conn, BoardVO board, String pass) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "update board set email=?, subject=?, contents=? where num=? and pass=?";
		int row = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getEmail());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContents());
			pstmt.setInt(4, board.getNum());
			pstmt.setString(5, pass);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
		return row;
	}

	// 리스트
	public List<BoardVO> board_list(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from board order by num desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			BoardVO vo = null;
			while (rs.next()) {
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setEmail(rs.getString("email"));
				vo.setIndate(rs.getString("indate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
		return list;
	}

	// 뷰
	public BoardVO board_view(Connection conn, int num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from board where num=?";
		BoardVO vo = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setEmail(rs.getString("email"));
				vo.setIndate(rs.getString("indate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
		return vo;
	}

	// 조회수증가
	public void board_hit(Connection conn, int num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "update board set readcnt=readcnt+1 where num=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
	}

	// 삭제 메소드
	public int board_delete(Connection conn, int num, String pass) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "delete from board where num=? and pass=?";
		int row = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setString(2, pass);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
			} catch (Exception e) {
			}
		}
		return row;
	}
}
