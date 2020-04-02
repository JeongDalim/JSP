<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*,Jdbc_0529_Guest_Bean.*"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<%
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "JSLDB";
	String password = "6007";

	Connection conn = null;
	PreparedStatement ps = null;

	try {
		Class.forName(myDriver);
		out.print("드라이버 성공");
	} catch (Exception e) {
		out.print(e);
		out.print("드라이버 실패");
	}
	try {
		conn = DriverManager.getConnection(url, user, password);
		out.print("커넥션 성공");
		String sql = "delete from board where num=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, num);
		ps.executeUpdate();
	} catch (Exception e) {
		out.print(e);
		out.print("커넥션 실패");
	} finally {
		try {
			ps.close();
			conn.close();
		} catch (Exception e) {
		}
	}
	response.sendRedirect("board_list.jsp");
%>