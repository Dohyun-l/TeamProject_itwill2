package com.deco.share;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.Action;
import com.deco.ActionForward;

public class shareWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		req.setCharacterEncoding("utf-8");
		
		System.out.println("제목 : " + req.getParameter("title"));
		System.out.println("작성자 : " + req.getParameter("nickname"));
		System.out.println("내용 : " + req.getParameter("content"));
		
		
		
		
		return null;
	}

}
