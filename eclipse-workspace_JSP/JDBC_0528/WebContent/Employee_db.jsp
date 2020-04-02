<%@ page import="java.util.*,java.sql.*,jdbc_0528.vo.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Connection myConn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<EmployeeBean> list = new ArrayList<EmployeeBean>();
	EmployeeBean eb = null;
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "JSLDB";
	String password = "6007";
	String sql = "select * from employee order by hiredate";
	try {
		Class.forName(myDriver);
		out.print("드라이버 연결 성공");
	} catch (Exception e) {
		out.print("드라이버 연결 실패");
	}
	try {
		myConn = DriverManager.getConnection(url, user, password);
		ps = myConn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			eb = new EmployeeBean();
			eb.setEno(rs.getInt("eno"));
			eb.setEname(rs.getString("ename"));
			eb.setJob(rs.getString("job"));
			eb.setManager(rs.getInt("manager"));
			eb.setHiredate(rs.getString("hiredate"));
			eb.setSalary(rs.getInt("salary"));
			eb.setCommission(rs.getInt("commission"));
			eb.setDno(rs.getInt("dno"));
			list.add(eb);
		}
	} catch (Exception e) {
		out.print(e);
	} finally {
		try {
			rs.close();
			ps.close();
			myConn.close();
		} catch (Exception e) {
			out.print(e);
		}
	}
	request.setAttribute("list", list);
	RequestDispatcher rd = request.getRequestDispatcher("Employee_list.jsp");
	rd.forward(request, response);
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