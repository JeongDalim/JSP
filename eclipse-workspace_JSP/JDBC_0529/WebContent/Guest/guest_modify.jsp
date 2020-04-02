<%@ page import="Jdbc_0529_Guest_Bean.*,java.sql.*"
	contentType="text/html; charset=UTF-8"%>
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
	request.setAttribute("gb", gb);
%>
<html>
<head>
<title>방명록 수정</title>
<link rel="stylesheet" type="text/css" href="/stylesheet.css">
<script type="text/javascript">
function in_check(){
	input.submit();
}
</script>
</head>

<body topmargin="0" leftmargin="0">
	<table border="0" width="800">
		<tr>
			<td width="20%" height="500" bgcolor="#ecf1ef" valign="top">
				<!-- 다음에 추가할 부분 "-->

			</td>
			<td width="80%" valign="top">&nbsp;<br> <img
				src="./img/bullet-01.gif"><font size="3" face="돋움"
				color="blue"> <b>방 명 록</b></font> <font size="2"> - 수정하기</font>
			<p>
					<img src="./img/bullet-03.gif"><font size="2" face="돋움"
						color="orange"> 잠깐</font> &nbsp; <img src="./img/bullet-02.gif"><font
						size="2" face="돋움">는 필수 입력 사항입니다.</font>
				<p>
				<form method="post" action="guest_modify_pro.jsp" name="input">
					<input type="hidden" name="idx" value="${gb.idx }"> <input
						type="hidden" name="page" value="">

					<table border="0">
						<tr>
							<td width="5%" align="right"><img src="./img/bullet-02.gif"></td>
							<td width="15%"><font size="2 face="돋움"">글쓴이</font></td>
							<td width="80%"><input type="text" size="20" name="name"
								value="${gb.name}" readonly></td>
						</tr>
						<tr>
							<td align="right"><img src="./img/bullet-02.gif"></td>
							<td><font size="2" face="돋움">제목</font></td>
							<td><input type="text" size="60" name="subject"
								value="${gb.subject}"></td>
						</tr>
						<tr>
							<td align="right"><img src="./img/bullet-02.gif"></td>
							<td><font size="2" face="돋움">내용</font></td>
							<td><textarea wrap="physical" rows="10" name="contents"
									cols="60">${gb.contents}</textarea></td>
						</tr>
						<tr>
							<td align="right">&nbsp;</td>
							<td><font size="2">&nbsp;</font></td>
							<td><input type="button" value="수정하기" onClick="in_check();">&nbsp;
								<input type="button" value="돌아가기" onClick="history.back();"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
