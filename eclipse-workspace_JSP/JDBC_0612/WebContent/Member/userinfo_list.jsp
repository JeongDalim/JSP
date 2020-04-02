<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>회원목록 보여주기</title>

<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
--->
</STYLE>
</head>
<body>
<table width="550" border="1" cellspacing="0" cellpadding="2" bordercolorlight="#173E7C" bordercolordark="white">

  <tr>
    <td width=50 align=center>번호</td>
    <td width=50 align=center>ID</td>
    <td width=120 align=center>이름</td>
    <td width=100 align=center>전화번호</td>
    <td width=100 align=center>등록일자</td>
    <td width=100 align=center>최근접속일</td>
  </tr>
  
  <c:if test="${empty list}">
      <td align=center colspan="6">등록된 자료가 존재하지 않습니다.</td>  
  </c:if>
  
  
  <c:if test="${!empty list}">
  <c:set var="num" value="${list.size() }"></c:set>
  <c:forEach var="member" items="${list}">
   <tr>
      <td align=center>${num}</td>
      <td align=center>${member.userid}</td>
      <td width=300>${member.name}</td>
      <td align=center>${member.tel}</td>
      <td align=center>${member.first_time.substring(0,10)}</td>
      <td align=center>${member.first_time.substring(0,10)}</td>
   </tr>
   <c:set var="num" value="${num-1}"></c:set>
  </c:forEach>
  </c:if>
  
</table>
<table width=550>
  <tr>
    <td>
      <select name="search_gubun">
        <option >이름 </option>
        <option >주소 </option>
    </td>
    <td>  찾는이름:
          <input type="text" name="search_name" size=10> &nbsp;
          <input type=hidden name="user_id" >[조회]</a>
          <c:if test="${empty session}">
          <a href="login.do">[로그인]</a>
          </c:if>
          <c:if test="${not empty session}">
          <a href="logout.do">[로그아웃]</a>
          </c:if>
          <c:if test="${empty session}">
          <a href="insert.do">[회원가입]</a>
          </c:if>
          <c:if test="${not empty session}">
          <a href="modify.do?userid=${session}">[수정]</a>
          </c:if>
     </td>
   </tr>
</table>
현재 세션 : ${session}
</body>
</html>
