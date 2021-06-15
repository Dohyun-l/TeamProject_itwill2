<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
<title>Join</title>
</head>
<body>

<main>
	<form action="./user/joinAction" method="post">
		<h2>회원가입</h2>
		<input type="text" name="name" id="name" placeholder="name">
		<input type="text" name="email" id="email" placeholder="email">
		<input type="password" name="pw" id="pw" placeholder="pw">
		<input type="password" name="pw2" id="pw2" placeholder="pw2">
	</form>
</main>
</body>
</html>