package com.deco.notice.action;

import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.notice.db.noticeDAO;
import com.deco.notice.db.noticeDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 전달된 정보 (파라미터 저장)
		noticeDTO nDTO = new noticeDTO();
		nDTO.setTitle(request.getParameter("title"));
		nDTO.setContent(request.getParameter("content"));
		
		noticeDAO nDAO = new noticeDAO();
		nDAO.insertNotice(nDTO);
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./noticelist.nt");
		forward.setRedirect(true);
		
		return forward;
	}

}
