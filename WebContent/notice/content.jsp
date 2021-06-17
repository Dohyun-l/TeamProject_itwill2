<%@page import="com.deco.notice.db.noticeDAO"%>
<%@page import="com.deco.notice.db.noticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/board/content.jsp</h1>
	<%
		// 페이지 이동시 전달정보(파라미터)가 있으면 항상 가장 먼저 저당
		// num, pageNum
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pageNum = request.getParameter("pageNum");
		
		// BoardDAO 객체 생성
		noticeDAO nDAO = new noticeDAO();
		
		// 글 조회수를 1증가 (DB 처리)
		nDAO.updateReadcount(idx);
		
		// DB에서 글번호(num)에 해당하는 글정보를 모두 가져와서 출력
		noticeDTO nDTO = nDAO.getBoard(idx);
	%>
	
	<table border="1">
		<tr>
			<td>글번호</td>
			<td><%=nDTO.getIdx()%></td>
			<td>작성자</td>
			<td><%=nDTO.getUser_num()%></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%=nDTO.getCreate_at()%></td>
			<td>조회수</td>
			<td><%=nDTO.getCount()%></td>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3"><%=nDTO.getTitle()%></td>
		</tr>
		<tr>
			<td colspan="4"><%=nDTO.getContent()%></td>
		</tr>
		
		<tr>
			<td>file</td>
			<td colspan="3">
				<a href="../upload/<%=nDTO.getFile()%>"><%=nDTO.getFile()%></a>
			</td>
		</tr>
<%-- 		<tr>
			<td colspan="4">
			<input type="button" value="수정하기" 
				onclick="location.href='updateForm.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>';">
			<input type="button" value="삭제하기" 
				onclick="location.href='deleteForm.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>';">
			<input type="button" value="답글쓰기"
				onclick="location.href='reWriteForm.jsp?num=<%=bb.getNum()%>&re_ref=<%=bb.getRe_ref()%>&re_lev=<%=bb.getRe_lev()%>&re_seq=<%=bb.getRe_seq()%>';">
			<input type="button" value="목록으로" onclick="location.href='list.jsp?pageNum=<%=pageNum%>';">
			</td>
		</tr> --%>
	</table>

</body>
</html>