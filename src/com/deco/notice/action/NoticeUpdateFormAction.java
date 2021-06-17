package com.deco.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.notice.db.noticeDAO;
import com.deco.notice.db.noticeDTO;


public class NoticeUpdateFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("M : NoticeUpdateFormAction_execute() 호출");
		
		// 전달된 파라미터값 num저장
		int idx = Integer.parseInt(request.getParameter("idx"));
		// DB객체 생성후 getGoods(num);
		noticeDAO nDAO = new noticeDAO();
		noticeDTO nDTO = nDAO.getBoard(idx);
		
		// 저장
		request.setAttribute("nDTO", nDTO);
		
		// 페이지 이동(admin_goods_modify.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./admingoods/admin_goods_modify.jsp");
		forward.setRedirect(false);		
		
		return forward;
	}
	

}
