<%@ page import="Jdbc_0529_Guest_Bean.*,java.sql.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%!String lineBreak(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\n') {
				sb.append("<br>");
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}%> --%>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
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
		String sql2 = "update guest set readcnt=readcnt+1 where idx=?";
		ps = conn.prepareStatement(sql2);
		ps.setInt(1, idx);
		ps.executeUpdate();

		String sql = "select * from guest where idx=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, idx);
		rs = ps.executeQuery();
		if (rs.next()) {
			gb = new GuestBean();
			gb.setIdx(rs.getInt("idx"));
			gb.setName(rs.getString("name"));
			gb.setSubject(rs.getString("subject"));
			gb.setContents(rs.getString("contents"));
			gb.setIndate(rs.getString("indate"));
			gb.setReadcnt(rs.getInt("readcnt"));
		}
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
/* 	if (gb.getContents() != null) {
		gb.setContents(lineBreak(gb.getContents()));
	} */
	request.setAttribute("gb", gb);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>방명록 내용 보기</title>
<link rel="stylesheet" type="text/css" href="/stylesheet.css">
<style type="text/css">
td.title {
	padding: 4px;
	background-color: #e3e9ff
}

td.content {
	padding: 10px;
	line-height: 1.6em;
	text-align: justify;
}

a.list {
	text-decoration: none;
	color: black;
	font-size: 10pt;
}
</style>
<script language="javascript">
function guest_delete(idx){
	sw = confirm("삭제할까요?");
	if(sw==true){
		location.href="guest_delete_pro.jsp?idx="+idx;
	}else{
		alert("리스트로 돌아갑니다.");
		location.href="guest_list.jsp";
	}
}
</script>
</head>
<body topmargin="0" leftmargin="0">
	<table border="0" width="800">
		<tr>
			<td width="20%" height="500" bgcolor="#ecf1ef" valign="top">
				<!--  다음에 추가할 부분 -->

			</td>
			<td width="80%" valign="top">&nbsp;<br>
				<table border="0" width="90%" align="center">
					<tr>
						<td colspan="2"><img src="./img/bullet-01.gif"> <font
							color="blue" size="3">방 명 록</font><font size="2"> - 글읽기</font></td>
					</tr>
				</table>
				<p>
				<table border="0" width="90%" align="center" cellspacing="0"
					style="border-width: 1px; border-color: #0066cc; border-style: outset;">
					<tr bgcolor="e3e9ff">
						<td class="title"><img src="./img/bullet-04.gif"> <font
							size="2" face="돋움"> ${gb.subject }</font></td>
					</tr>
					<tr>
						<td class="content">
							<p align="right">
								<font size="2" face="돋움">${gb.name } / <font size="2"
									face="돋움">${gb.indate } / ${gb.readcnt }번 읽음</font>
									<p>
										<textarea rows="3" cols="70">
									${gb.contents}
									</textarea>
									<p>
						</td>
					</tr>
				</table> <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
				<p align="center">
					<font size="2"> <!-- 목록보기 --> 
					<a href="guest_list.jsp"><img src="./img/list-2.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="guest_modify.jsp?idx=${gb.idx }"><img src="./img/edit.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#" onClick="guest_delete(${gb.idx })"><img src="./img/del.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
				</font></td>
		</tr>
	</table>
</body>
</html>
