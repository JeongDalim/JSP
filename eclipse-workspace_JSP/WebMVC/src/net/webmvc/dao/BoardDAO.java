package net.webmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.webmvc.dto.BoardVO;
import net.webmvc.util.DBUtil;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> list(Connection conn) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sam_board";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getDate("regdate").toString());
				vo.setUpdatedate(rs.getDate("updatedate").toString());
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
		return list;
	}

	public List<BoardVO> list(Connection conn, int pagestart, int endpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from(select rownum rn, idx,name,pass,subject,email,contents,readcnt,regdate,updatedate from sam_board where rownum <= ? order by idx desc) where rn > ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getDate("regdate").toString());
				vo.setUpdatedate(rs.getDate("updatedate").toString());
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

	public void write(Connection conn, BoardVO vo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into sam_board (idx,name,pass,subject,contents) values (sam_board_seq_idx.nextval,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getSubject());
			ps.setString(4, vo.getContents());
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
	}

	public void modify(Connection conn, BoardVO vo, int idx) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update sam_board set subject=?,contents=? where idx=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getSubject());
			ps.setString(2, vo.getContents());
			ps.setInt(3, idx);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
	}

	public BoardVO view(Connection conn, int idx) {
		BoardVO vo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sam_board where idx=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getDate("regdate").toString());
				vo.setUpdatedate(rs.getDate("updatedate").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
		return vo;
	}

	public void delete(Connection conn, int idx) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete sam_board where idx=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
	}

	public int count(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "select count(*) from sam_board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return row;
	}

	public int search_count(Connection conn, String search, String key) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) from sam_board where " + search + " like '%" + key + "%'";
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

	public List<BoardVO> list_search(Connection conn, String s_query, int pagestart, int endpage) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select idx,subject,regdate,readcnt,contents from "
				+ "(select rownum rn,idx,subject,regdate,readcnt,contents from sam_board where " + s_query
				+ " and rownum<= ? " + "order by idx desc) where " + s_query + " and rn > ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, endpage);
			ps.setInt(2, pagestart);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getDate("regdate").toString());
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
		return list;
	}

	public int hits(Connection conn, int idx) {
		PreparedStatement ps = null;
		int row = 0;
		String query = "update sam_board set readcnt=readcnt+1 where idx=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, idx);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
		}
		return row;
	}
}
