<%@ page import="Jdbc_0529_Guest_Bean.*,java.sql.*"
	contentType="text/html; charset=UTF-8"%>
<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
%>
<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "jsldb";
	String password = "6007";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	GuestBean gb = null;
%>
<%
	try {
		Class.forName(driver);
	} catch (Exception e) {
		out.print("드라이버실패");
	}
	try {
		conn = DriverManager.getConnection(url, user, password);
		String sql = "update guest set subject=?,contents=? where idx=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, subject);
		ps.setString(2, contents);
		ps.setInt(3, idx);
		ps.executeUpdate();
	} catch (Exception e) {
		out.print(e);
		out.print("커넥션실패");
	} finally {
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {

		}
	}
	response.sendRedirect("guest_list.jsp");
%>
