package net.webmvc.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.webmvc.dto.PdsVO;
import net.webmvc.util.DBUtil;

public class PdsDAO {
	private PdsDAO() {
	}

	private static PdsDAO instance = new PdsDAO();

	public static PdsDAO getInstance() {
		return instance;
	}

	public List<PdsVO> list(Connection conn) {
		List<PdsVO> list = new ArrayList<PdsVO>();
		PdsVO vo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sam_pds";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getDate("regdate").toString());
				vo.setUpdatedate(rs.getDate("updatedate").toString());
				vo.setFilename(rs.getString("filename"));
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

	public List<PdsVO> list(Connection conn, int pagestart, int endpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from(select rownum rn, idx,name,subject,contents,readcnt,regdate,updatedate from sam_pds where rownum <= ? order by idx desc) where rn > ?";
		List<PdsVO> list = new ArrayList<PdsVO>();
		PdsVO vo = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
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

	public void write(Connection conn, PdsVO vo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into sam_pds (idx,name,pass,subject,contents,filename) values (sam_pds_seq_idx.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getSubject());
			ps.setString(4, vo.getContents());
			ps.setString(5, vo.getFilename());
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
	}

	public void modify(Connection conn, PdsVO vo, int idx) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select filename from sam_pds where idx=?";
		String filename = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				filename = rs.getString("filename");
				File file = new File(
						"C:/Users/FOREVER/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/WebMVC/upload/"
								+ filename);
				if (file.exists()) {
					System.out.println("Áö¿ò");
					file.delete();
				}
			}
			sql = "update sam_pds set subject=?,contents=?,filename=? where idx=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getSubject());
			ps.setString(2, vo.getContents());
			ps.setString(3, vo.getFilename());
			ps.setInt(4, idx);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
		}
	}

	public PdsVO view(Connection conn, int idx) {
		PdsVO vo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sam_pds where idx=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getDate("regdate").toString());
				vo.setUpdatedate(rs.getDate("updatedate").toString());
				vo.setFilename(rs.getString("filename"));
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
		String sql = "select filename from sam_pds where idx=?";
		String filename = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				filename = rs.getString("filename");
				File file = new File(
						"C:/Users/FOREVER/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/WebMVC/upload/"
								+ filename);
				if (file.exists()) {
					file.delete();
				}
			}
			sql = "delete sam_pds where idx=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
		}
	}

	public int count(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "select count(*) from sam_pds";
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
		String query = "select count(*) from sam_pds where " + search + " like '%" + key + "%'";
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

	public List<PdsVO> list_search(Connection conn, String s_query, int pagestart, int endpage) {
		List<PdsVO> list = new ArrayList<PdsVO>();
		PdsVO vo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select idx,name,subject,regdate,readcnt,contents from "
				+ "(select rownum rn,idx,name,subject,regdate,readcnt,contents from sam_pds where " + s_query
				+ " and rownum<= ? " + "order by idx desc) where " + s_query + " and rn > ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, endpage);
			ps.setInt(2, pagestart);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
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
		String query = "update sam_pds set readcnt=readcnt+1 where idx=?";
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
