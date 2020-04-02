<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
<fmt:timeZone value="GMT-8">
<fmt:formatDate value="${now}" type="both" dateStyle="full"/>
</fmt:timeZone>
<p/>
<fmt:setLocale value="ja_JP"/>
통화: <fmt:formatNumber value="10000" type="currency"></fmt:formatNumber><p/>
<fmt:formatDate value="${now }"/>
</body>
</html>