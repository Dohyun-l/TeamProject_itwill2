<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WebContent/notice/noticeform.jsp</h1>

<form action="./NoticeInsertAction.nt" method="post">
	제목 <input type="text" name="title"> <br>
	<hr>
	<%-- <jsp:include page="./index.jsp"></jsp:include> --%>
	<!-- 내용 : <input type="text" name="content"> -->
	내용
	<textarea rows="10" cols="30" name="content"></textarea>
	<hr>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
</form>




</body>
</html>