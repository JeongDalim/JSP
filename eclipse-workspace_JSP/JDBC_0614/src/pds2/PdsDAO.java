package pds2;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PdsDAO {
	private PdsDAO() {

	}

	private static PdsDAO instance = new PdsDAO();

	public static PdsDAO getInstance() {
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

	public List<PdsBean> list() {
		PdsBean bean = null;
		List<PdsBean> list = new ArrayList<PdsBean>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from pds";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new PdsBean();
				bean.setName(rs.getString("name"));
				bean.setNum(rs.getInt("num"));
				bean.setEmail(rs.getString("email"));
				bean.setSubject(rs.getString("subject"));
				bean.setPass(rs.getString("pass"));
				bean.setFilename(rs.getString("filename"));
				bean.setReadcnt(rs.getInt("readcnt"));
				bean.setIndate(rs.getString("indate"));
				bean.setContents(rs.getString("contents"));
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

	public PdsBean view(int num) {
		PdsBean bean = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from pds where num=?";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new PdsBean();
				bean.setName(rs.getString("name"));
				bean.setNum(rs.getInt("num"));
				bean.setEmail(rs.getString("email"));
				bean.setSubject(rs.getString("subject"));
				bean.setPass(rs.getString("pass"));
				bean.setFilename(rs.getString("filename"));
				bean.setReadcnt(rs.getInt("readcnt"));
				bean.setIndate(rs.getString("indate"));
				bean.setContents(rs.getString("contents"));
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

	public void hits(PdsBean bean) {
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt = bean.getReadcnt();
		cnt++;
		try {
			String sql = "update pds set readcnt=? where num=?";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cnt);
			ps.setInt(2, bean.getNum());
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

	public void write(PdsBean bean) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into pds(num,name,email,subject,pass,filename,contents) values (pds_seq_num.nextval,?,?,?,?,?,?)";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getSubject());
			ps.setString(4, bean.getPass());
			ps.setString(5, bean.getFilename());
			ps.setString(6, bean.getContents());
			if (ps.executeUpdate() != 0) {
				System.out.println("글쓰기 성공");
			} else {
				System.out.println("실패");
			}
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

	public int delete(String pass) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String path = " C:/Users/FOREVER/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/JDBC_0614/upload/";
		try {
			String sql = "select filename from pds where pass=?";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				String filename = rs.getString("filename");
				File a = new File(path + filename);
				if (a.isFile()) {
					a.delete();
				}
			}
			sql = "delete from pds where pass=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			result = ps.executeUpdate();
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
		return result;
	}

	public void modify(PdsBean bean) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String path = "C:/Users/FOREVER/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/JDBC_0614/upload/";
			String sql = "select filename from pds where pass=?";
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getPass());
			rs = ps.executeQuery();
			if (rs.next()) {
				String filename = rs.getString("filename");
				File a = new File(path + filename);
				if (a.isFile()) {
					a.delete();
				}
			}
			sql = "update pds set name=?, email=? ,subject=?,contents=?,filename=? where num=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getSubject());
			ps.setString(4, bean.getContents());
			ps.setString(5, bean.getFilename());
			ps.setInt(6, bean.getNum());
			if (ps.executeUpdate() != 0) {
				System.out.println("수정성공");
			} else {
				System.out.println("실패");
			}
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
}
