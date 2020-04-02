<%@ page import="java.util.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!List<String[]> list = new ArrayList<String[]>();%>
<%
	String name = request.getParameter("name");
	String money = request.getParameter("money");
	String[] arr = new String[3];
	arr[0] = name;
	arr[1] = money;
	int pay = Integer.parseInt(money);

	int oman = 0;
	int man = 0;
	int ochun = 0;
	int chun = 0;
	int oback = 0;
	int back = 0;
	int oship = 0;
	int ship = 0;
	int o = 0;
	int il = 0;

	if (pay > 0) {
		oman = pay / 50000;
		pay = pay % 50000;
		man = pay / 10000;
		pay = pay % 10000;
		ochun = pay / 5000;
		pay = pay % 5000;
		chun = pay / 1000;
		pay = pay % 1000;
		oback = pay / 500;
		pay = pay % 500;
		back = pay / 100;
		pay = pay % 100;
		oship = pay / 50;
		pay = pay % 50;
		ship = pay / 10;
		pay = pay % 10;
		o = pay / 5;
		pay = pay % 5;

		il = pay;
	}
	arr[2] = oman + "\t" + man + "\t" + ochun + "\t" + chun + "\t" + oback + "\t" + back + "\t" + oship + "\t"
			+ ship + "\t" + o + "\t" + il;

	if (!name.equals("Quit")) {
		RequestDispatcher rd = request.getRequestDispatcher("input.jsp");
		rd.forward(request, response);
		list.add(arr);
	}
	String title = "이름\t금액\t50000\t10000\t5000\t1000\t500\t100\t50\t10\t5\t1";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
	<h2>출장비 지급내역서</h2>
<%
	out.println(title);
	for (int i = 0; i < list.size(); i++) {
		out.print(list.get(i)[0] + "\t");
		out.print(list.get(i)[1] + "\t");
		out.println(list.get(i)[2]);
	}
%>
	</pre>
</body>
</html>