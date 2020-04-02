package dbcpGuest.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbcpGuest.guest.model.GuestVO;
import dbcpGuest.guest.util.DBUtil;

public class GuestDAO {
	private GuestDAO() {
	}

	private static GuestDAO instance = new GuestDAO();

	public static GuestDAO getInstance() {

		return instance;
	}

	public List<GuestVO> list(Connection conn) {
		List<GuestVO> list = new ArrayList<GuestVO>();
		GuestVO vo = null;
		String sql = "select * from guest";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setIndate(rs.getDate("indate").toString());
				vo.setReadcnt(rs.getInt("readcnt"));
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

	public int listCount(Connection conn) {
		String sql = "select count(*) from guest";
		int row = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
		return row;
	}

	// 방명록 등록 메소드

	public void guestWrite(GuestVO guest, Connection conn) {
		String query = "insert into guest(idx,name,subject,contents)" + "values(guest_idx.nextval,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, guest.getName());
			ps.setString(2, guest.getSubject());
			ps.setString(3, guest.getContents());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(ps);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public GuestVO guestView(int idx, Connection conn) {
		String query = "select * from guest where idx = " + idx;
		PreparedStatement ps = null;
		ResultSet rs = null;
		GuestVO vo = null;
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContents(rs.getString("contents"));
				vo.setSubject(rs.getString("subject"));
				vo.setIndate(rs.getString("indate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
		return vo;
	}

	public void guestModify(int idx, GuestVO guest, Connection conn) {
		String query = "update guest set subject=?, contents=? where idx=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, guest.getSubject());
			ps.setString(2, guest.getContents());
			ps.setInt(3, guest.getIdx());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
		}
	}

	public void guestDelete(int idx, Connection conn) {
		String query = "delete from guest where idx=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, idx);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
		}
	}
}