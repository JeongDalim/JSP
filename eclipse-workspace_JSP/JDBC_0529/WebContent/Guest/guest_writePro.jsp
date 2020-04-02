<%@ page import="Jdbc_0529_Guest_Bean.*,java.sql.*"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String contents = "";
	if (request.getParameter("contents") != null) {
		contents = request.getParameter("contents");
	}
	GuestBean gb = new GuestBean();
	gb.setName(name);
	gb.setSubject(subject);
	gb.setContents(contents);
%>

<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "jsldb";
	String password = "6007";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
%>

<%
	String sql = "insert into guest(idx,name,subject,contents) values(guest_idx.nextval,?,?,?)";  
	//String sql = "select * from guest order by indate desc";
	try {
		Class.forName(driver);
		//out.print("성공");
	} catch (Exception e) {
		out.print("실패");
	}
	try {
		conn = DriverManager.getConnection(url, user, password);
		ps = conn.prepareStatement(sql);
		ps.setString(1, gb.getName());
		ps.setString(2, gb.getSubject());
		ps.setString(3, gb.getContents());
		ps.executeUpdate();
	} catch (Exception e) {
		out.print("실패");
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
