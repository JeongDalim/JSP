<%@ page import="Jdbc_0529_Guest_Bean.*,java.sql.*"
	contentType="text/html; charset=UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("idx"));
%>
<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "jsldb";
	String password = "6007";

	Connection conn = null;
	PreparedStatement ps = null;
%>

<%
	try {
		Class.forName(driver);
	} catch (Exception e) {
		out.print("드라이버실패");
	}
	try {
		conn = DriverManager.getConnection(url, user, password);
		String sql = "delete from guest where num=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, num);
		ps.executeUpdate();
	} catch (Exception e) {
		out.print(e);
		out.print("커넥션실패");
	} finally {
		try {
			ps.close();
			conn.close();
		} catch (Exception e) {

		}
	}
	response.sendRedirect("guest_list.jsp");
%>