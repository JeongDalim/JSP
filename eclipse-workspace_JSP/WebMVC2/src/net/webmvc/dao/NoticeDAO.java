package net.webmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.webmvc.dto.NoticeVO;
import net.webmvc.util.DBUtil;

public class NoticeDAO {
	private NoticeDAO() {
	}

	private static NoticeDAO instance = new NoticeDAO();

	public static NoticeDAO getInstance() {
		return instance;
	}

	public List<NoticeVO> list(Connection conn) {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sam_notice";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setIdx(rs.getInt("idx"));
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

	public void write(Connection conn, NoticeVO vo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into sam_notice (idx,subject,contents) values (sam_notice_seq_idx.nextval,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getSubject());
			ps.setString(2, vo.getContents());
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
	}

	public void modify(Connection conn, NoticeVO vo, int idx) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update sam_notice set subject=?,contents=? where idx=?";
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

	public NoticeVO view(Connection conn, int idx) {
		NoticeVO vo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sam_notice where idx=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new NoticeVO();
				vo.setIdx(rs.getInt("idx"));
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
		String sql = "delete sam_notice where idx=?";
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
}
