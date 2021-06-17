<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/member/main.jsp</h1>
	
<%-- 	<%
		// 사용자가 로그인을 했을때만 main페이지 확인
		// 로그인 안한 경우 로그인 페이지로 이동
		
		// 세션객체의 정보를 가져와서 확인
		String id = (String)session.getAttribute("id");
	
		if(id == null){
			// 로그인 x
			System.out.println("[main.jsp] : 아이디가 없음 -> 로그인페이지 이동");
			response.sendRedirect("./MemberLogin.me");
		}
	%>
	
	<h2><%= id %>님 환영합니다~!</h2>
	<h2>${sessionScope.id }</h2>
	
	<input type="button" value="로그아웃!" onclick="location.href='./MemberLogout.me';"> --%>
	
	
	<h3><a href="./noticeform.nt"> 게시판 폼 </a></h3>
	<h3><a href="./noticelist.nt"> 게시판 리스트 </a></h3>


	
	<!-- 관리자만 사용가능한 메뉴 생성 -->
<%-- 	<% 
	if(id != null){	// 아이디가 있을때
		if(id.equals("admin")){ 
		// 참조형데이터 값 비교시 항상 null값을 먼저 비교후 데이터 비교
		//if(id != null && id.equals("admin"))	(o)
		//if(id.equals("admin") && id != null)	(x)
	%>
		
	<h3><a href="./MemberList.me">회원 목록보기</a></h3>
	
	<% 
		} 
	}%> --%>


</body>
</html>