package com.deco.share;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.Action;
import com.deco.ActionForward;

public class shareWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {

		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String nickname = req.getParameter("nickname");
		String title =req.getParameter("title");
		String content =req.getParameter("content");
		
		System.out.println(nickname);
		System.out.println(title);
		System.out.println(content);
		
		
		return null;
	}

}
