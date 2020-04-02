package Jdbc_0530_Board_Bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	DBManager dbm = new DBManager();
	BoardBean bean = null;
	List<BoardBean> list = null;

	public List<BoardBean> list() throws Exception {
		list = new ArrayList<BoardBean>();
		try {
			conn = dbm.getConnection();
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

	public BoardBean view(int num) throws Exception {
		bean = new BoardBean();
		try {
			conn = dbm.getConnection();
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

	public void write(String name, String email, String subject, String contents, String pass, int readcnt) {
		try {
			conn = dbm.getConnection();
			String sql = "insert into board(num,name,email,subject,contents,pass,readcnt) values(board_num.nextval,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, subject);
			ps.setString(4, contents);
			ps.setString(5, pass);
			ps.setInt(6, readcnt);
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

	public void delete(int num) {
		try {
			conn = dbm.getConnection();
			String sql = "delete from board where num=?";
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
				System.out.println(e);
			} finally {
				try {
					ps.close();
					conn.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public void modify(int num, String subject, String contents) throws Exception {
		try {
			conn = dbm.getConnection();
			String sql = "update board set subject=?,contents=? where num=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, subject);
			ps.setString(2, contents);
			ps.setInt(3, num);
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
}
