
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	 noticeDTO nDTO = request.getAttribute("");
  


<form>
제목: <input type="text" name="title">
<jsp:include page="./index.jsp"></jsp:include>
<input type="submit" value="글 쓰기">


</form>




</body>
</html>