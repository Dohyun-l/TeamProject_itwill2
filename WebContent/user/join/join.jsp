<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
<link rel="stylesheet" href="./user/join/style.css">
<title>Join</title>
</head>
<body>

<main>
	<form id="joinForm" action="joinAction.us" method="post">
		<h2>회원가입</h2>
		<input type="text" name="email" id="email" placeholder="이메일">
		<input type="password" name="pw" id="pw" placeholder="비밀번호">
		<input type="password" name="pw2" id="pw2" placeholder="비밀번호 확인">
		<input type="text" name="name" id="name" placeholder="이름">
		<input type="text" name="nickname" id="nickname" placeholder="닉네임">
		<input type="text" name="phone" id="phone" placeholder="휴대전화">
		<input type="text" name="addr" id="addr" placeholder="주소">
		<button onclick="callAddress()">주소찾기</button>

		<div class="subInputContainer">
			<div class="cofirmContainer"></div>
			<div class="InputContainer">
				<div>
				<input type="text" name="major" class="subjectInput" id="major" placeholder="전문분야">
				</div>
				<div id="searchBox1"></div>
			</div>	
		</div>

		<div class="subInputContainer">
			<div class="cofirmContainer"></div>
			<div class="InputContainer">
				<div>
				<input type="text" name="inter" class="subjectInput" id="inter" placeholder="관심분야">
				</div>
				<div id="searchBox1"></div>
			</div>	
		</div>
		</div>
		<button id="joinSubmit">회원가입</button>
	</form>
</main>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="./user/join/js/addrAPI.js"></script>
<script type="module" src="./user/join/js/searchData.js"></script>
<script type="module" src="./user/join/js/searchSubject.js"></script>
</body>
</html>