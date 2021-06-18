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


<form action="./NoticeInsertAction.nt" method="post" enctype="multipart/form-data" name="fr">
		제목 <input type="text" name="title">
		<hr>
		<input type="file" name="file">
		<hr>
		<!-- 원래 이름 : name="ir1" -->
		<textarea name="content" id="ir1" rows="10" cols="100" style="width:766px; height:412px; display:none;"></textarea>
</form>
<jsp:include page="./index.html"></jsp:include>
<hr>
<input type="button" onclick="submitContents();" value="글 작성" />
<input type="button" value="목록으로" onclick="location.href='noticelist.nt';">

</body>
</html>