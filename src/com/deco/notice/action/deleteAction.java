package com.deco.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.Action;
import com.deco.ActionForward;
import com.deco.notice.db.DeleteTestDAO;

public class deleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		ActionForward forward = new ActionForward("./notice/list", true);
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		
	
		DeleteTestDAO dtDAO = new DeleteTestDAO();
		
		dtDAO.deleteNotice(idx);

		return forward;
	}

}
