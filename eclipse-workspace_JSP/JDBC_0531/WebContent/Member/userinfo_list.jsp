<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="jdbc_0531_member.*,jdbc_0531_util.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	MemberManager mm = MemberManager.getInstance();
	List<MemberBean> list = mm.list();
	request.setAttribute("list", list);
%>
<html>
<head>
<title>회원목록 보여주기</title>

<STYLE TYPE="text/css">
<!--
body {
	font-family: 돋움, Verdana;
	font-size: 9pt
}

td {
	font-family: 돋움, Verdana;
	font-size: 9pt;
	text-decoration: none;
	color: #000000
}
-
-->
</STYLE>
</head>
<body>
	<table width="550" border="1" cellspacing="0" cellpadding="2"
		bordercolorlight="#173E7C" bordercolordark="white">
		<tr>
			<td width=50 align=center>번호</td>
			<td width=80 align=center>아이디</td>
			<td width=120 align=center>이름</td>
			<td width=100 align=center>연락처</td>
			<td width=100 align=center>가입일자</td>
		</tr>
		<c:if test="${!empty list }">
			<c:set var="num" value="${list.size()}"></c:set>
			<c:forEach var="m" items="${list}">
				<tr>
					<td align=center>${num}</td>
					<td align=center><a
						href="userinfo_modify.jsp?userid=${m.userid}">${m.userid }</a></td>
					<td width=300>${m.name }</td>
					<td align=center>${m.tel }</td>
					<td align=center>${m.first_time.substring(0,10) }</td>
				</tr>
				<c:set var="num" value="${num-1 }"></c:set>
			</c:forEach>
		</c:if>
		<c:if test="${empty list }">
			<tr>
				<td width=300 colspan="5" align="center">등록된 회원이 없습니다.</td>
			</tr>
		</c:if>
	</table>
	<table width=550>
		<tr>
			<td><select name="search_gubun">
					<option>이름</option>
					<option>주소</option></td>
			<td>찾는이름: <input type="text" name="search_name" size=10>
				<a href="userlogin_form.jsp"><input type="button" value="로그인"></a>
				<a href="userinfo_insert.jsp"><input type="button" value="회원가입"></a>
			</td>
		</tr>
	</table>
</body>
</html>
