<%@page import="com.deco.user.userDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src='https://www.google.com/recaptcha/api.js'></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>정보 공유 - 글쓰기</title>
<script type="text/javascript">
function readContent(){
	
}
</script>
</head>
<body>
	<h1>WebContent/share/writeShare.jsp</h1>
	
	
	
	
	<%
		/* int userNum = Integer.parseInt((String)session.getAttribute("user_num"));
	
		userDAO udao = new userDAO();
		String nickname = udao.getUserNickNameByNum(userNum); */
		String nickname = "admin";
		
		// enctype="multipart/form-data"
	%>
	
	
	<fieldset>
		<form action="./shareWriteAction" method="post" onsubmit="readContent()" name="fr">
		<input type="text" id="nickname" name="nickname" value="<%=nickname%>"readonly><br>
		 <br>
				  
		<input type="text" name="title" placeholder="제목을 입력해주세요"><br>
		<!-- 네이버 에디터.. -->
		<jsp:include page="shareEditor.html"/>
		
		
		
		<hr>
		<br>
		<!-- 로봇이 아닙니다 체크하기 -->
		<div class="g-recaptcha" data-sitekey="6LdQ1zEbAAAAAOzJAHtwDc8LTdr2vNQffqV-K15l">

		<input type="submit" value="등록">
		<input type="reset" value="취소">     
		</form>
	</fieldset>

</body>
</html>