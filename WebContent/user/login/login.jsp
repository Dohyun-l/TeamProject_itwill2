<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deco</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function check(){
	if(document.fr.email.value == ""){
		alert("이메일을 입력하세요");
		document.fr.email.focus();
		return false;
	}
	if(document.fr.pw.value == ""){
		alert("비밀번호를 입력하세요");
		document.fr.pw.focus();
		return false;
	}
}
</script>
</head>
<body>

 <form action="./UserLoginAction" method="post" onsubmit="return check();">
 <center>
 	<h2>로그인</h2><br>
 	<label>이메일</label><br>
 	<input type="email" name="email" size="20" style="text-align:center"><br>
 	<label>비밀번호</label><br>
 	<input type="password" name="pw" size="20" style="text-align:center"><br>
 	<br>
 	<input type="submit" value="로그인"> | <input type="button" value="회원가입" onclick="">
 </center>
 </form>
</body>
</html>