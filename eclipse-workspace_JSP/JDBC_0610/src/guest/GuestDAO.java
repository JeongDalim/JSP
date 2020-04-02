package guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GuestDAO {
	private GuestDAO() {
	}

	private static GuestDAO instance = new GuestDAO();

	public static GuestDAO getInstance() {
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

	public List<GuestBean> GuestList() {
		List<GuestBean> list = new ArrayList<GuestBean>();
		GuestBean bean = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from guest order by indate desc";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new GuestBean();
				bean.setIdx(rs.getInt("idx"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setContents(rs.getString("contents"));
				bean.setIndate(rs.getString("indate"));
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
	
	public GuestBean bean(int idx) {
		GuestBean bean = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from guest where idx=?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new GuestBean();
				bean.setIdx(rs.getInt("idx"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setContents(rs.getString("contents"));
				bean.setIndate(rs.getString("indate"));
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
		String sql = "update guest set readcnt=readcnt+1 where idx=?";
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

	public int GuestInsert(GuestBean bean) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into guest(idx,name,subject,contents) values(guest_idx.nextval,?,?,?)";
		int row = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getSubject());
			ps.setString(3, bean.getContents());
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
}
