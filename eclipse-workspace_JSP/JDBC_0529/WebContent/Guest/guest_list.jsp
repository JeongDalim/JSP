<%@ page import="java.util.*,Jdbc_0529_Guest_Bean.*,java.sql.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "jsldb";
	String password = "6007";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<GuestBean> list = new ArrayList<GuestBean>();
	GuestBean gb = null;
%>

<%
	String sql = "select * from guest order by idx desc";
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
		rs = ps.executeQuery();
		while (rs.next()) {
			gb = new GuestBean();
			gb.setIdx(rs.getInt("idx"));
			gb.setName(rs.getString("name"));
			gb.setSubject(rs.getString("subject"));
			gb.setContents(rs.getString("contents"));
			gb.setIndate(rs.getString("indate"));
			gb.setReadcnt(rs.getInt("readcnt"));
			gb.setIp(rs.getString("ip"));
			list.add(gb);
		}
		//out.print("성공");
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
	request.setAttribute("list", list);
%>

<html>
<head>
<title>방명록 읽기</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<style type="text/css">
a.list {
	text-decoration: none;
	color: black;
	font-size: 10pt;
}
</style>
</head>
<body bgcolor="#FFFFFF" topmargin="0" leftmargin="0">
	<table border="0" width="800">
		<tr>
			<td width="20%" height="500" valign="top" bgcolor="#ecf1ef">
				<!-- 다음에 추가할 부분 -->
			</td>
			<td width="80%" valign="top"><br>
				<table border="0" cellspacing="1" width="100%" align="center">
					<tr>
						<td colspan="7" align="center" valign="center" height="20"><font
							size="4" face="돋움" color="blue"> <img
								src="./img/bullet-01.gif"> <b>방 명 록</b></font></td>
					</tr>
					<tr>
						<td colspan="5" align="right" valign="middle" height="20"><font
							size="2" face="고딕">전체 : ${list.size() }건 - 3 Pages </font></td>
					</tr>
					<tr bgcolor="e3e9ff">
						<td width="10%" align="center" height="20"><font face="돋움"
							size="2">번호</font></td>
						<td width="50%" align="center" height="20"><font face="돋움"
							size="2">제목</font></td>
						<td width="15%" align="center" height="20"><font face="돋움"
							size="2">글쓴이</font></td>
						<td width="15%" align="center" height="20"><font face="돋움"
							size="2">작성일</font></td>
						<td width="10%" align="center" height="20"><font face="돋움"
							size="2">조회수</font></td>
					</tr>
					<c:if test="${list.size()==0 }">
						<tr onMouseOver="style.backgroundColor='#D1EEEE'"
							onMouseOut="style.backgroundColor=''">
							<td align="left" height="20" colspan="5" align="center"><font
								face="돋움" size="2" color="#000000">등록된 자료가 존재하지 않습니다.</td>
						<tr>
					</c:if>
					<c:if test="${list.size()!=0 }">
					<c:set var="cnt" value="${list.size() }"></c:set>
						<c:forEach var="guest" items="${list}">
							<tr onMouseOver="style.backgroundColor='#D1EEEE'"
								onMouseOut="style.backgroundColor=''">
								<td align="center" height="25"><font face="돋움" size="2"
									color="#000000">${cnt }</font></td>
								<td align="left" height="20"><font face="돋움" size="2"
									color="#000000"><a
										href="guest_view.jsp?idx=${guest.idx}">${guest.subject }</a></td>
								<td align="center" height="20"><font face="돋움" size="2">
										<a class="list" href="mailto:ein1027@nate.com">${guest.name }</a>
								</font></td>
								<td align="center" height="20"><font face="돋움" size="2">${guest.indate.substring(0,11)}</font></td>
								<td align="center" height="20"><font face="돋움" size="2">${guest.readcnt}</font></td>
							</tr>
							<c:set var="cnt" value="${cnt-1 }"></c:set>
						</c:forEach>
					</c:if>
					<tr>
						<div align="center">
							<table width="700" border="0" cellspacing="0" cellpadding="5">
								<tr>&nbsp;
								</tr>

								<td colspan="5">
									<div align="center">[1][2][3]</div>
								</td>
					</tr>
					<tr align=right>
						<td colspan="5"><a href="guest_write.jsp"> <img
								src="./img/write.gif" border="0"></a></td>
					</tr>
				</table>
				</div>
</body>
</html>

