<%@ page import="java.util.*" contentType="text/html; charset=UTF-8" %>
<%
request.setCharacterEncoding("utf-8");

String addr = request.getParameter("addr");
String zipcode=null;
if(addr!=null){
Map<String, String> zip = new HashMap<String, String>();

zip.put("11111", "대전 중구 일류동");
zip.put("22222", "대전 중구 이류동");
zip.put("33333", "대전 중구 삼류동");
zip.put("44444", "대전 중구 사류동");
zip.put("55555", "대전 중구 오류동");
zip.put("66666", "대전 중구 육류동");
zip.put("77777", "대전 중구 칠류동");

zipcode=zip.get(addr);
}
%>
<HTML>
<HEAD>
<TITLE>우편번호 찾기</TITLE>

<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000}
a    { font-family: 돋움, Verdana; color: #000000; text-decoration: none}
     a:link { font-family:돋움; font-size:9pt; text-decoration:none}
     a:visited { font-family:돋움; font-size:9pt; text-decoration:none}
     a:hover { font-family:돋움; text-decoration:underline }
-->
</STYLE>
<script type="text/javascript">
function post_close(){
	self.close();
}
function post_search(){
	if(inquiry.addr.value==""){
		alert("동이름 입력");
		post.addr.focus();
		return;
	}
	inquiry.action="post_check.jsp?addr="+inquiry.addr.value;
	inquiry.submit();
}
function post_send(){
	opener.document.form_name.zip.value="<%=zipcode%>";
	opener.document.form_name.addr1.value="<%=addr%>";
	self.close();
}
</script>
</HEAD>

<BODY BGCOLOR="#FFFFFF" onLoad="document.inquiry.addr.focus();">
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="./img/u_b02.gif"></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>우편번호 찾기</FONT></td>
    <td align=right><img src= "./img/u_b03.gif"></td>
  </tr>
</table>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330><TR><TD BGCOLOR=#948DCF>
  <TABLE CELLPADDING=0 CELLSPACING=1 BORDER=0 WIDTH=330><TR><TD>
    <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=3 WIDTH=100% BGCOLOR=#FFFFFF>
 <FORM NAME="inquiry" METHOD="post" ACTION="post_check.jsp" onSubmit="return check();">
      <TR>
        <TD ALIGN=CENTER><br>
          동이름 입력 : <INPUT NAME="addr" TYPE="text" style="width:120">
      <a href="#" onClick="post_search()" ><INPUT TYPE="image" src="./img/u_bt08.gif" hspace=10></a>
        </TD>
      </TR>
      <TR>
        <TD ALIGN=CENTER>
        ※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.
        </TD>
      </TR>
      
     <%if(zipcode!=null) {%>
      <TR>
      <TD><a href="#" onClick="post_send()"><%=addr%>-<%=zipcode%></a>
        </TD>
      </TR>
      <%}%>
      
      
    </FORM>
    </TABLE>
  </TD></TR></TABLE>
</TD></TR></TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="./img/u_b04.gif"></td>
    <td align=right><img src="./img/u_b05.gif"></td>
  </tr>
  <tr>
    <td colspan=2 align=center>
     <a href="#" onClick="post_close()"><img src="./img/u_bt13.gif" border=0 vspace=5></a></td>
  </tr>
</table>
</BODY>
</HTML>
