<%@ page import="java.util.*" import="Day_0527.javaBean.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<NocticeBean> list = new ArrayList<NocticeBean>();
list.add(new NocticeBean(1,"AAA","2019-01-01",4));
list.add(new NocticeBean(4,"DDD","2019-05-01",3));
list.add(new NocticeBean(3,"CCC","2019-11-01",2));
list.add(new NocticeBean(2,"BBB","2019-02-01",5));
list.add(new NocticeBean(5,"EEE","2019-03-01",6));
list.add(new NocticeBean(8,"HHH","2019-09-01",7));
list.add(new NocticeBean(6,"FFF","2019-12-01",12));
list.add(new NocticeBean(7,"GGG","2019-07-01",2));

request.setAttribute("list", list);
request.setAttribute("count", list.size());
RequestDispatcher rd = request.getRequestDispatcher("notice_list.jsp");
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