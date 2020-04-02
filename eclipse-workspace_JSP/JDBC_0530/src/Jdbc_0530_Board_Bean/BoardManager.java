package Jdbc_0530_Board_Bean;

import java.util.*;
import java.sql.*;

public class BoardManager {
	private BoardManager() {
	}

	private static BoardManager instance = new BoardManager();

	public static BoardManager getInstance() {
		return instance;
	}

	public List<BoardBean> list() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		BoardBean bean = null;
		List<BoardBean> list = new ArrayList<BoardBean>();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from board";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new BoardBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setPass(rs.getString("pass"));
				bean.setIndate(rs.getString("indate"));
				bean.setEmail(rs.getString("email"));
				bean.setSubject(rs.getString("subject"));
				bean.setContents(rs.getString("contents"));
				bean.setReadcnt(rs.getInt("readcnt"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	public int write(String name, String email, String subject, String contents, String pass, int readcnt) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into board(num,name,email,subject,contents,pass,readcnt) values(board_num.nextval,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, subject);
			ps.setString(4, contents);
			ps.setString(5, pass);
			ps.setInt(6, readcnt);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public void hits(int num) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update board set readcnt=readcnt+1 where num=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public BoardBean view(int num) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardBean bean = new BoardBean();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from board where num=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setPass(rs.getString("pass"));
				bean.setIndate(rs.getString("indate"));
				bean.setEmail(rs.getString("email"));
				bean.setSubject(rs.getString("subject"));
				bean.setContents(rs.getString("contents"));
				bean.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return bean;
	}

	public int delete(int num) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from board where num=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					ps.close();
					conn.close();
				} catch (Exception e) {
				}
			}
		}
		return result;
	}

	public int modify(int num, String subject, String contents) throws Exception {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update board set subject=?,contents=? where num=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, subject);
			ps.setString(2, contents);
			ps.setInt(3, num);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return result;
	}
}
