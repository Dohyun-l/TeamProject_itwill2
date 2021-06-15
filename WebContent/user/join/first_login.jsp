<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 직후 로그인 성공시</title>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
</head>
<body>
	<main></main>
		<form action="./user/firstLoginAction" method="post">
			<h2>추가정보 입력</h2>
			<input type="text" name="nickname" id="nickname" placeholder="닉네임">
			<input type="text" name="phone" id="phone" placeholder="휴대전화 ex)010-0000-0000">
			<input type="text" name="addr" id="addr" placeholder="주소">
			<input type="text" name="addr2" id="addr2" placeholder="상세주소">
			<input type="text" name="major" id="major" placeholder="전문분야">
			<input type="text" name="inter" id="inter" placeholder="관심분야">
		</form>
	</main>
</body>
</html>