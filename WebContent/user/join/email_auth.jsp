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
		<form action="./emailAuthAction.us" method="post">
			<h2>이메일 인증을 해주세요!</h2>
			<h4>입력하신 이메일 주소로 인증번호를 발송했습니다.</h4>
			<input type="text" name="email_auth" id="email_auth" placeholder="인증번호">
		</form>
	</main>
</body>
</html>