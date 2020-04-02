<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.sql.*,Jdbc_0530_Board_Bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	BoardManager manager = BoardManager.getInstance();
	BoardBean bean = manager.view(num);
	//쿠키검사 boardCookie+num(프라이머리 키)
	Cookie cookie = null;
	boolean sw = false;
	Cookie[] cookies = request.getCookies(); //클라이언트에 존재하는 모든 쿠키 가져오기
	for (int i = 0; i < cookies.length; i++) { //쿠키만큼 반복해서
		cookie = cookies[i]; //하나씩 null에 대입
		if (cookie.getName().equals("boardCookie" + num)) { //만약 가져온 쿠키중 내가 정의한 쿠키값이 있다면
			sw = true; //트루 
			break; //브레이꾸
		}
	}
	String newValue = "" + System.currentTimeMillis(); //쿠키 값 천만분의 1초로  설정
	if (!sw) { //쿠키가 없다면
		cookie = new Cookie("boardCookie" + num, newValue); // 쿠키를 만들고 (이름,값)
		response.addCookie(cookie); //추가해주기
		cookie.setMaxAge(24*60*60); //쿠키 유효기간도 설정
		manager.hits(num); //쿠키 검사해서 상황에 따라 조회수 증가, 쿠키가 없기에 조회수가 증가한다.
	}
	request.setAttribute("bean", bean);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>게시판 내용 보기</title>
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
							color="blue" size="3">자 유 게 시 판</font><font size="2"> -
								글읽기</font></td>
					</tr>
				</table>
				<p>
				<table border="0" width="90%" align="center" cellspacing="0"
					style="border-width: 1px; border-color: #0066cc; border-style: outset;">
					<tr bgcolor="e3e9ff">
						<td class="title"><img src="./img/bullet-04.gif"> <font
							size="2" face="돋움"> ${bean.subject }</font></td>
					</tr>
					<tr>
						<td class="content">
							<p align="right">
								<font size="2" face="돋움"> <a class="list"
									href="mailto:ein1027@nate.com">${bean.name }</a> / <font
									size="2" face="돋움">${bean.indate } / ${bean.readcnt }번
										읽음</font>
									<p>${bean.contents }
									<p>
										<!--contents의 내용을 <BR>태그로 처리-->
						</td>
					</tr>
				</table> <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
				<p align="center">
					<font size="2"> <!-- 새글쓰기 --> <a href=""> <img
							src="./img/write.jpg" border="0"></a>&nbsp;&nbsp; <!-- 답글쓰기 -->
						<a href=""> <img src="./img/reply.gif" border="0"></a>&nbsp;&nbsp;
						<!-- 수정하기 --> <a href="board_modify.jsp?num=${bean.num}"><img
							src="./img/edit.gif" border="0"></a>&nbsp;&nbsp; <!-- 삭제하기 -->
						<a href="board_delete.jsp?num=${bean.num }&pass=${bean.pass}"><img
							src="./img/del.gif" border="0"></a>&nbsp;&nbsp; <!-- 목록보기 --> <a
						href="board_list.jsp"><img src="./img/list-2.gif" border="0"></a>&nbsp;&nbsp;
					</font></td>
		</tr>
	</table>
</body>
</html>