package memberDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import memberBean.MemberBean;
import zipBean.ZipBean;

public class MemberDAO {

	private MemberDAO() {

	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
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

	public List<MemberBean> list() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberBean mb = null;
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			conn = getConnection();
			String sql = "select * from member";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				mb = new MemberBean();
				mb.setIdx(rs.getInt("idx"));
				mb.setName(rs.getString("name"));
				mb.setUserid(rs.getString("userid"));
				mb.setPasswd(rs.getString("passwd"));
				mb.setZipcode(rs.getString("zipcode"));
				mb.setAddr1(rs.getString("addr1"));
				mb.setAddr2(rs.getString("addr2"));
				mb.setTel(rs.getString("tel"));
				mb.setEmail(rs.getString("email"));
				mb.setJob(rs.getString("job"));
				mb.setIntro(rs.getString("intro"));
				mb.setFavorite(rs.getString("favorite"));
				mb.setFirst_time(rs.getString("first_time"));
				mb.setLast_time(rs.getString("last_time"));
				list.add(mb);
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

	public MemberBean mb(String userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberBean mb = null;
		try {
			conn = getConnection();
			String sql = "select * from member where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				mb = new MemberBean();
				mb.setIdx(rs.getInt("idx"));
				mb.setName(rs.getString("name"));
				mb.setUserid(rs.getString("userid"));
				mb.setPasswd(rs.getString("passwd"));
				mb.setZipcode(rs.getString("zipcode"));
				mb.setAddr1(rs.getString("addr1"));
				mb.setAddr2(rs.getString("addr2"));
				mb.setTel(rs.getString("tel"));
				mb.setEmail(rs.getString("email"));
				mb.setJob(rs.getString("job"));
				mb.setIntro(rs.getString("intro"));
				mb.setFavorite(rs.getString("favorite"));
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
		return mb;
	}

	public MemberBean login(String userid, String passwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberBean mb = null;
		try {
			conn = getConnection();
			String sql = "select * from member where userid=? and passwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				mb = new MemberBean();
				mb.setIdx(rs.getInt("idx"));
				mb.setName(rs.getString("name"));
				mb.setUserid(rs.getString("userid"));
				mb.setPasswd(rs.getString("passwd"));
				mb.setZipcode(rs.getString("zipcode"));
				mb.setAddr1(rs.getString("addr1"));
				mb.setAddr2(rs.getString("addr2"));
				mb.setTel(rs.getString("tel"));
				mb.setEmail(rs.getString("email"));
				mb.setJob(rs.getString("job"));
				mb.setIntro(rs.getString("intro"));
				mb.setFavorite(rs.getString("favorite"));
				mb.setFirst_time(rs.getString("first_time"));
				mb.setLast_time(rs.getString("last_time"));
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
		return mb;
	}

	public int write(MemberBean mb) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = getConnection();
			String sql = "insert into member(idx, name , userid , passwd,zipcode, tel, email,addr1,addr2,favorite,job,intro) values(member_seq_idx.nextval,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getName());
			ps.setString(2, mb.getUserid());
			ps.setString(3, mb.getPasswd());
			ps.setString(4, mb.getZipcode());
			ps.setString(5, mb.getTel());
			ps.setString(6, mb.getEmail());
			ps.setString(7, mb.getAddr1());
			ps.setString(8, mb.getAddr2());
			ps.setString(9, mb.getFavorite());
			ps.setString(10, mb.getJob());
			ps.setString(11, mb.getIntro());
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

	public int memberIdCheck(String user_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = getConnection();
			String sql = "select count(*) as cnt from member where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");
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
		return result;
	}

	public List<ZipBean> ZipList(String addr) {
		ZipBean zbean = null;
		List<ZipBean> list = new ArrayList<ZipBean>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from zipcode where dong like '%" + addr + "%'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				zbean = new ZipBean();
				zbean.setZipcode(rs.getString("zipcode"));
				zbean.setNo(rs.getString("no"));
				zbean.setSido(rs.getString("sido"));
				zbean.setGugun(rs.getString("gugun"));
				zbean.setDong(rs.getString("dong"));
				zbean.setBunji(rs.getString("bunji"));
				list.add(zbean);
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

	public int modify(MemberBean mb) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update member set zipcode=?,addr1=?,addr2=?,tel=?,email=?,job=?,intro=?,favorite=? where userid=?";
		int result = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getZipcode());
			ps.setString(2, mb.getAddr1());
			ps.setString(3, mb.getAddr2());
			ps.setString(4, mb.getTel());
			ps.setString(5, mb.getEmail());
			ps.setString(6, mb.getJob());
			ps.setString(7, mb.getIntro());
			ps.setString(8, mb.getFavorite());
			ps.setString(9, mb.getUserid());
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

	public int delete(String userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete member where userid=?";
		int result = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
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
