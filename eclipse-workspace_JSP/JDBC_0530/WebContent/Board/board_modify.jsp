<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*,Jdbc_0530_Board_Bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	ResultSet rs = null;
	BoardBean bb = null;

	try {
		Class.forName(myDriver);
		//out.print("드라이버 성공");
	} catch (Exception e) {
		out.print(e);
		out.print("드라이버 실패");
	}
	try {
		conn = DriverManager.getConnection(url, user, password);
		//out.print("커넥션 성공");
		String sql = "select * from board where num=" + num;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			bb = new BoardBean();
			bb.setNum(rs.getInt("num"));
			bb.setName(rs.getString("name"));
			bb.setPass(rs.getString("pass"));
			bb.setIndate(rs.getString("indate"));
			bb.setEmail(rs.getString("email"));
			bb.setSubject(rs.getString("subject"));
			bb.setContents(rs.getString("contents"));
			bb.setReadcnt(rs.getInt("readcnt"));
		}
	} catch (Exception e) {
		out.print(e);
		out.print("커넥션 실패");
	} finally {
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
		}
	}
	request.setAttribute("bb", bb);
%>
<head>
<title>게시판 수정</title>
<link rel="stylesheet" type="text/css" href="/stylesheet.css">
<script type="text/javascript">
function go(num){
	if (bform.name.value == "") {
		alert("이름은 필수입력 사항입니다.");
		bform.name.focus();
		return;
	}
	if (bform.subject.value == "") {
		alert("제목은 필수입력 사항입니다.");
		bform.subject.focus();
		return;
	}
	if (bform.contents.value == "") {
		alert("내용은 필수입력 사항입니다.");
		bform.contents.focus();
		return;
	}
	if (bform.pass.value == "") {
		alert("비밀번호는 필수입력 사항입니다.");
		bform.pass.focus();
		return;
	}
	if(bform.pw.value==bform.pass.value){
		alert("수정완료");
		bform.action="board_modify_pro.jsp?num="+num;
		bform.submit();	
}else{
	alert("비밀번호가 틀립니다. 다시입력해 주십시오.");
	bform.pass.focus();
}
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
				color="blue"> <b>자 유 게 시 판</b></font> <font size="2"> - 수정하기</font>
				<p>
					<img src="./img/bullet-03.gif"><font size="2" face="돋움"
						color="orange"> 잠깐</font> &nbsp; <img src="./img/bullet-02.gif"><font
						size="2" face="돋움">는 필수 입력 사항입니다.</font>
				<p>
				<form name="bform" method="post">

					<table border="0">
						<tr>
							<td width="5%" align="right"><img src="./img/bullet-02.gif"></td>
							<td width="15%"><font size="2 face="돋움"">글쓴이</font></td>
							<td width="80%"><input type="text" size="20" name="name"
								value="${bb.name }" readonly></td>
						</tr>
						<tr>
							<td align="right">&nbsp;</td>
							<td><font size="2 face="돋움"">메일주소</font></td>
							<td><input type="text" size="20" name="email"
								value="${bb.email }"></td>
						</tr>
						<tr>
							<td align="right"><img src="./img/bullet-02.gif"></td>
							<td><font size="2" face="돋움">제 목</font></td>
							<td><input type="text" size="60" name="subject"
								value="${bb.subject }"></td>
						</tr>
						<tr>
							<td align="right"><img src="./img/bullet-02.gif"></td>
							<td><font size="2" face="돋움">내용</font></td>
							<td><textarea wrap="physical" rows="10" name="contents"
									cols="60">${bb.contents }</textarea></td>
						</tr>
						<tr>
							<td align="right"><img src="./img/bullet-02.gif"></td>
							<td><font size="2" face="돋움">비밀번호</font></td>
							<td><input type="password" size="10" name="pass"> <font
								size="2" face="돋움">*.수정과 삭제시 꼭 입력하셔야 합니다.</font></td>
						</tr>
						<tr>
							<td align="right">&nbsp;</td>
							<td><font size="2">&nbsp;</font></td>
							<td><a href="#" onClick="go(${bb.num})"><img
									src="./img/edit2.gif" border=0></a>&nbsp; <a href=""><img
									src="./img/cancle.gif" border=0></a></td>
						</tr>
					</table>
					<input type="hidden" name="pw" value="${bb.pass }">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
