package com.jslhrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jslhrd.bean.BoardBean;

//import ,.GuestBean;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envConext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envConext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}

	public List<BoardBean> BoardList() {
		List<BoardBean> list = new ArrayList<BoardBean>();
		BoardBean bean = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new BoardBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setPass(rs.getString("pass"));
				bean.setEmail(rs.getString("email"));
				bean.setIndate(rs.getString("indate"));
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
				System.out.println(e);
			}
		}
		return list;
	}

	public BoardBean BoardView(int num) {
		BoardBean bean = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board where num=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new BoardBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setPass(rs.getString("pass"));
				bean.setEmail(rs.getString("email"));
				bean.setIndate(rs.getString("indate"));
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
				System.out.println(e);
			}
		}
		return bean;
	}

	public void hits(int idx) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update board set readcnt=readcnt+1 where idx=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public int BoardWrite(BoardBean bean) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into board(num,name,pass,email,subject,contents,readcnt) values(board_num.nextval,?,?,?,?,?,1)";
		int row = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2,bean.getPass());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getSubject());
			ps.setString(5, bean.getContents());
			row = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return row;
	}

	public int BoardDelete(String pass) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete board where pass=?";
		int row = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			row = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return row;
	}
	
	public int BoardModify(BoardBean bean) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update board set email=?,subject=?,contents=? where num=?";
		int row = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getEmail());
			ps.setString(2, bean.getSubject());
			ps.setString(3, bean.getContents());
			ps.setInt(4, bean.getNum());
			row = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return row;
	}
}
