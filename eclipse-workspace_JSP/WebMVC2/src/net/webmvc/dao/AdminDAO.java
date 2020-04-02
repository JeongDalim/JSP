package net.webmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.webmvc.util.DBUtil;

public class AdminDAO {
	private AdminDAO() {
	}

	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	public boolean login(String adminid, String adminpass, Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sam_admin where adid=? and adpass=?";
		boolean sw = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, adminid);
			ps.setString(2, adminpass);
			rs = ps.executeQuery();
			if (rs.next()) {
				sw = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
		System.out.println(sw);
		return sw;
	}
}
