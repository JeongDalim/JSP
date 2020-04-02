<%@ page contentType="text/html; charset=UTF-8" %>
<%

request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String userid = request.getParameter("userid");
String passwd = request.getParameter("passwd");
String zip = request.getParameter("zip");
String addr1 = request.getParameter("addr1");
String addr2 = request.getParameter("addr2");
String tel = request.getParameter("tel");
String email= request.getParameter("email");
String fa = request.getParameter("fa");
String job = request.getParameter("job");

%>
<html>
<head>
<title>회원수정</title>
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000; BACKGROUND-POSITION: left top; BACKGROUND-REPEAT: no-repeat;}
-->
.formbox {
	BACKGROUND-COLOR: #F0F0F0; FONT-FAMILY: "Verdana", "Arial", "Helvetica", "돋움"; FONT-SIZE:9pt
} 
--->
</STYLE>
<script type="text/javascript">
function id_check(){
	
	if(form_name.userid.value==""){
		alert("아이디는 빈칸없이 입력하세요. 다시입력해 주십시오.");
		form_name.userid.focus();
		return;
	}else if(form_name.userid.value.length < 5 || form_name.userid.value.length > 15){
		alert("5~16자 이내의 영문이나 숫자만 가능합니다. 다시입력해 주십시오.");
		form_name.userid.focus();
		return;	
	}else if(a_or_d(form_name.userid.value)){
		alert("5~16자 이내의 영문이나 숫자만 가능합니다. 다시입력해 주십시오.");
		form_name.userid.focus();
		return;	
	}
	window.open("id_check.jsp?userid="+form_name.userid.value);	
}

function post_check(){
	
	window.open("post_check.jsp");
	
}


function insert_check(){
	var form=form_name;
	if(form.passwd.value==""){
		alert("비밀번호는 빈칸없이 입력하세요.");
		form.passwd.focus();
		return;
	}else if(form.passwd.value.length < 5 || form.passwd.value.length > 11){
		alert("5~12자 이내의 영문이나 숫자만 가능합니다. 다시입력해 주십시오.");
		form.passwd.focus();
		return;
	}else if(form.passwd.value != form.repasswd.value){
		alert("비밀번호가 다릅니다. 다시입력해 주십시오.");
		form.passwd.focus();
		return;
	}
	if(form.tel.value==""){
		alert("전화번호는 빈칸없이 입력하세요.");
		form.tel.focus();
		return;
	} 
	var sw=0;
	for(i=0; i<form.fa.length; i++){
		if(form.fa[i].checked){
			sw=1;
			}
		}
	if(sw==0){
		alert("관심분야를 1개 이상 선택하세요.");
		return;
		}
	if(form.job.selectedIndex==0){
		alert("직업을 선택하세요");
		return;
		}
 
    if(!tel_check(form.tel.value)){
    	alert("전화번호 형식 맞지 않습니다. 다시 입력해 주십시오.");
    	form.tel.focus();
    	return;
    	}
    if(!email_check(form.email.value)){
    	alert("이메일 형식 맞지 않습니다. 다시 입력해 주십시오.");
    	form.email.focus();
    	return;
    	}
    alert("등록성공!");
    form_name.action="userinfo_insert_pro2.jsp"
    form_name.submit();
    }

function a_or_d(str){
	var lower_str =str.toLowerCase(); //소문자로 변환
	for(i=0; i<lower_str.length; i++){
	var ch=lower_str.charAt(i);
	if(((ch<'a')||(ch>'z'))&&((ch<'0')||(ch>'9'))){ //영문자 및 숫자 이외에는 다 거르기
		return true;
		}else{
	    return false;	
		}
	}
}
function tel_check(str){
	str= str.split("-").join('');
	var phone = /^(010[0-9]{8})$/; //전화번호 정규식
	return phone.test(str);
}

function email_check(str){
	var email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //이메일 정규식
	return email.test(str);
}
</script>
</head>

<body bgcolor="#FFFFFF" LEFTMARGIN=0  TOPMARGIN=0 >
 
 <!-- 탑 메뉴 영역 삽입-->


<table border="0" width="800">
<tr>
  <td width="20%"  bgcolor="#ecf1ef" valign="top" style="padding-left:0;">
	
	<!--로그인 영역 삽입-->

  </td>
  <td width="80%" valign="top">&nbsp;<img src="./img/title1.gif" ><br>    
	<form name=form_name method=post action="userinfo_edit_pro.jsp">
	<table border=0 cellpadding=0 cellspacing=0 border=0 width=730 valign=top>
		<tr><td align=center><br>                            
			<table cellpadding=0 cellspacing=0 border=0 width=650 align=center>       
				<tr>
					<td bgcolor="#7AAAD5">            
						<table cellpadding=0 cellspacing=0 border=0 width=100%>
							<tr bgcolor=#7AAAD5>
								<td align=left BORDER="0" HSPACE="0" VSPACE="0"><img src="./img/u_b02.gif"></td>
								<td align=center bgcolor="#7AAAD5"><FONT COLOR="#FFFFFF"><b>사용자정보수정&nbsp;</b><font color=black>(</font><font color=red>&nbsp;*&nbsp;</font><font color=black>표시항목은 반드시 입력하십시요.)</font></FONT></td>
								<td align=right BORDER="0" HSPACE="0" VSPACE="0"><img src="./img/u_b03.gif"></td>
							</tr>
						</table>
						<table cellpadding=3 cellspacing=1 border=0 width=100%>
							<tr>
								<td width=110 bgcolor=#EFF4F8>&nbsp;회원 성명<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=name size=16 maxlength=20 value=<%=name%>>성명은 빈칸없이 입력하세요.
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;회원 ID<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<table cellspacing=0 cellpadding=0>
										<tr>
											<td align=absmiddle>
												<input type=text name=userid size=12 maxlength=16 value=<%=userid%> readonly style="width:120">
											</td>
											<td>
                  		<a href="#" onClick="id_check()"><img src="./img/u_bt01.gif" hspace=2 border=0 name=img1  align=absmiddle></a>
                   		5~16자 이내의 영문이나 숫자만 가능합니다.
                  		</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
								<input type=password name=passwd size=8 maxlength=12 style="width:80">
                 6~12자 이내의 영문이나 숫자만 가능합니다.
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호확인<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE><input type=password name=repasswd size=8 maxlength=12 value=<%=passwd%> style="width:80">비밀번호 확인을 위해서 비밀번호를 한번 더 입력해주세요. </td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;우편번호<font color=red>&nbsp;</font></td>
								<TD BGCOLOR=WHITE>
									<table cellspacing=0 cellpadding=0>
										<tr>
											<td>
                  				<input type=text name=zip size=6 maxlength=6 value=<%=zip %> >
                  		</td>
                  		<td>
      								<a href="#" onClick="post_check()"><img src="./img/u_bt07.gif" hspace=2 border=0 name=img2 align=absmiddle></a>
 											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;주소<font color=red>&nbsp;</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=addr1 size=50 maxlength=100 value=<%=addr1%>>
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;나머지 주소<font color=red>&nbsp;</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=addr2 size=50 maxlength=100 value=<%=addr2%>>
								</td>
							</tr>
							<tr>
               <TD BGCOLOR="#EFF4F8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <input type=text name=tel size=13 maxlength=13 value=<%=tel %>>
               </td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;E-mail
                	<font color=red>&nbsp;</font>
                </td>
                <td bgcolor=WHITE valign=middle>
                  <input type=text name=email size=30 maxlength=30 value=<%=email %>>
                </td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;관심분야
                	<font color=red>&nbsp;</font>
                </td>
								<td bgcolor=WHITE valign=middle> 
									<input type="checkbox" name="fa" value="건강" <%if(fa.contains("건강")){ %>checked<%} %>>건강 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="fa" value="문화예술" <%if(fa.contains("문화예술")){ %>checked<%} %>>문화예술 &nbsp;&nbsp;
									<input type="checkbox" name="fa" value="경제" <%if(fa.contains("경제")){ %>checked<%} %>>경제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="fa" value="연예오락" <%if(fa.contains("연예오락")){ %>checked<%} %>>연예오락 &nbsp;
									<input type="checkbox" name="fa" value="뉴스" <%if(fa.contains("뉴스")){ %>checked<%} %>>뉴스
									<br><input type="checkbox" name="fa" value="여행레져" <%if(fa.contains("여행레저")){ %>checked<%} %>>여행레져 &nbsp;&nbsp;
									<input type="checkbox" name="fa" value="생활" <%if(fa.contains("생활")){ %>checked<%} %>>생활 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="fa" value="스포츠" <%if(fa.contains("스포츠")){ %>checked<%} %>>스포츠 &nbsp;&nbsp;
									<input type="checkbox" name="fa" value="교육" <%if(fa.contains("교육")){ %>checked<%} %>>교육 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="fa" value="컴퓨터" <%if(fa.contains("컴퓨터")){ %>checked<%} %>>컴퓨터 &nbsp;&nbsp;
									<input type="checkbox" name="fa" value="학문" <%if(fa.contains("학문")){ %>checked<%} %>>학문 &nbsp;&nbsp;
								</td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;직업<font color=red>&nbsp;</font></td>
                <TD BGCOLOR=WHITE>
                  <select name=job class="formbox">
 										<option value="0">선택하세요 ---
 										<option value="회사원" <%if(job.equals("회사원")){%> selected <%} %>>회사원
 										<option value="연구전문직" <%if(job.equals("연구전문직")){%> selected <%} %>>연구전문직
 										<option value="교수학생" <%if(job.equals("교수학생")){%> selected <%} %>>교수학생
 										<option value="일반자영업" <%if(job.equals("일반자영업")){%> selected <%} %>>일반자영업
 										<option value="공무원" <%if(job.equals("공무원")){%> selected <%} %>>공무원
 										<option value="의료인" <%if(job.equals("의료인")){%> selected <%} %>>의료인
 										<option value="법조인" <%if(job.equals("법조인")){%> selected <%} %>>법조인
 										<option value="종교,언론,에술인" <%if(job.equals("종교,언론,에술인")){%> selected <%} %>>종교.언론/예술인
 										<option value="농,축,수산,광업인" <%if(job.equals("농,축,수산,광업인")){%> selected <%} %>>농/축/수산/광업인
 										<option value="주부" <%if(job.equals("주부")){%> selected <%} %>>주부
 										<option value="무직" <%if(job.equals("무직")){%> selected <%} %>>무직
 										<option value="기타" <%if(job.equals("기타")){%> selected <%} %>>기타
									</select>
								</td>                
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;자기소개<font color=red>&nbsp;</font></td>
                <TD BGCOLOR=WHITE>
                  <textarea cols=65 rows=5 name="intro"></textarea>
                </td>
              </tr>
            </table>
            <table cellpadding=0 cellspacing=0 border=0 width=100%>
              <tr bgcolor=#7AAAD5>
                <td valign=bottom>
                  <img src="./img/u_b04.gif" align=left hspace=0 vspace=0 border=0>
                </td>
                <td align=center></td>
                <td valign=bottom>
                  <img src="./img/u_b05.gif" align=right hspace=0 vspace=0 border=0>
                </td>
              </tr>
              <tr bgcolor=#ffffff>
                <td colspan=3 align=center>
                  <input type=submit value="수정하기"> 
                  <img src="./img/u_bt05.gif" border=0 hspace=10 vspace=3 name=img4>
                </td>
              </tr>
            </table> 
          </td>
        </tr>
      </td>
    </tr>
	</table>
	</form>
	</td>
</tr>
</table>
 <!-- copyright 영역 삽입-->
</body>
</html>
