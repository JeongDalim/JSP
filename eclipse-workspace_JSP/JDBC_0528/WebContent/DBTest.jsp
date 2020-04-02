<%@ page import="java.sql.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String myUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "JSLDB";
	String myPass = "6007";
%>
<%
	Connection myConn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	//오라클 접속 테스트
	try {
		Class.forName(myDriver);
		//out.print("드라이버 연결 성공");
	} catch (Exception e) {
		out.print(e);
		out.print("드라이버 연결 실패");
	}
	//DB 연결 테스트(Connection)
	try {
		myConn = DriverManager.getConnection(myUrl, myID, myPass);
		//out.print("커넥션 연결 성공");
		ps = myConn.prepareStatement("select * from department");
		rs = ps.executeQuery();
		while (rs.next()) {
			out.print(rs.getInt("dno") + "&nbsp;&nbsp;&nbsp;");
			out.print(rs.getString("dname") + "&nbsp;&nbsp;&nbsp;");
			out.print(rs.getString("loc") + "<br>");
		}
	} catch (Exception e) {
		out.print(e);
		out.print("커넥션 연결 실패");
	} finally {
		try {
			rs.close();
			ps.close();
			myConn.close();
		} catch (Exception e) {
			out.print(e);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>