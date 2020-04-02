<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.sql.*,Jdbc_0529_Guest_Bean.*"%>
<%
	String name = request.getParameter("name");
	String email = "";
	if (request.getParameter("email") != null) {
		email = request.getParameter("email");
	}
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	String pass = request.getParameter("pass");
	int readcnt = 0;

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
		String sql = "insert into board(num,name,email,subject,contents,pass,readcnt) values(board_num.nextval,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, subject);
		ps.setString(4, contents);
		ps.setString(5, pass);
		ps.setInt(6, readcnt);
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