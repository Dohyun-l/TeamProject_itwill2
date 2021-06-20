<%@page import="com.deco.notice.db.noticeDTO"%>
<%@page import="com.deco.notice.db.noticeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/board/list.jsp</h1>
	
	<script type="text/javascript">
		var pageNum = 1;
	
		function PageChange(){
	      pageSize = document.fr.pageChange.value;
	      location.href = "noticelist.nt?pageNum=" + pageNum + "&pageSize="+ pageSize;
	   }
	</script>
	
	
	<%
	
	
		// 디비에 저장된 글의 개수를 알기
		
		// BoardDAO 객체 생성
		noticeDAO nDAO = new noticeDAO();
		// 디비에 글의 수를 계산하는 메서드 생성 -> 호출
		// getBoardCount();
		int cnt = nDAO.getBoardCount();
		
		/////////////////////////////////////////////////
		// 게시판 페이징 처리 : DB에서 원하는 만큼만 글 가져오기
		
		// 한 페이지당 보여줄 글의 개수
		String pages = request.getParameter("pageSize");
		if(pages == null){
			pages = "10";
		}
		
		// 현 페이지가 몇페이지인지 확인
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		int pageSize = Integer.parseInt(pages);
		
		// 페이지별 시작행 계산하기
		// 1p -> 1번, 2p -> 11번, 3p -> 21번, .... => 일반화
		int currentPage = Integer.parseInt(pageNum);
   		int startRow = (currentPage-1)*pageSize+1;
		
		// 끝행 계산하기
		// 1p -> 10번, 2p -> 20번, 3p -> 30번, ... => 일반화
		int endRow = currentPage*pageSize;
		
		/////////////////////////////////////////////////
		
		// 디비에 저장된 모든 글정보를 가져오기
		//ArrayList boardListAll = bdao.getBoardList();
		
		// 디비에 저장된 모든 글 중에서 원하는만큼만 가져오기(페이지 사이즈)
		ArrayList boardList = nDAO.getBoardList(startRow, pageSize);
		
	%>
	
	<h2> ITWILL 게시판 글목록 [총 : <%= cnt %>개] </h2>
	
		<h3><a href="./Main.nt">메인으로</a></h3>
		<h3><a href="./noticeform.nt">공지글쓰기</a></h3>
		
		<form name="fr">
		<select name="pageChange" id="pageChange" onchange="PageChange()">
			<option value="">몇개씩 보기</option>
			<option value="5">5개씩 보기</option>
			<option value="10">10개씩 보기</option>
			<option value="15">15개씩 보기</option>
			<option value="20">20개씩 보기</option>
		</select>
		</form>
		<br>
		
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>제목</td>
			<!-- <td>내용</td> -->
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<% 
		for(int i=0; i<boardList.size(); i++){
				noticeDTO nDTO = (noticeDTO)boardList.get(i);	
		%>
		<tr>
			<td><%=nDTO.getIdx() %></td>
			<td><%=nDTO.getUser_num() %></td>
			<td>
			<a href="noticecontent.nt?idx=<%=nDTO.getIdx()%>&pageNum=<%=pageNum%>&cnt=<%=cnt%>"><%=nDTO.getTitle()%></a>
			</td>
			<%-- <td><%=nDTO.getContent() %></td> --%>
			<td><%=nDTO.getCreate_at() %></td>
			<td><%=nDTO.getCount() %></td>
		</tr>
		<% 
		}
		%>
	</table>
	
	<hr>
	<%
		//////////////////////////////////////////////////////////////////////
		// 페이지 처리 - 하단부 페이지 링크
		
		if(cnt != 0){	// 글이 있을때 표시
			// 전체 페이지수 계산
			// ex) 총 50개 -> 한 페이지당 10개씩 출력, 5개
			//	      총 57개 -> 한 페이지당 10개씩 출력, 6개
			int pageCount = cnt / pageSize+(cnt % pageSize == 0? 0 : 1);
			
			// 한 화면에 보여줄 페이지 번호의 개수 (페이지 블럭)
			int pageBlock = 5;
			
			// 페이지 블럭의 시작페이지 번호
			// ex) 1~10페이지 : 1, 11~20페이지 : 11, 21~30페이지 : 21
			int startPage = ((currentPage-1)/pageBlock) * pageBlock+1;
			
			// 페이지 블럭의 끝페이지 번호
			int endPage = startPage + pageBlock-1;
			
			if(endPage > pageCount){
				endPage = pageCount;
			}
			
			// 이전 (해당 페이지블럭의 첫번째 페이지 호출)
			if(startPage > pageBlock){
				%>
				<a href="noticelist.nt?pageNum=<%= startPage-pageBlock %>">[이전]</a>
				<%
			}
			
			// 숫자 1....5
			for(int i=startPage; i<=endPage;i++){
				%>
				<a href="noticelist.nt?pageNum=<%=i %>">[<%= i %>]</a>
				<%
			}
			
			// 다음 (기존의 페이지 블럭보다 페이지의 수가 많을때)
			if(endPage < pageCount){
				%>
				<a href="noticelist.nt?pageNum=<%= startPage+pageBlock %>">[다음]</a>
				<%
			}
			
	
			
			
		}
		
	
		//////////////////////////////////////////////////////////////////////
	%>
	
	
	

</body>
</html>