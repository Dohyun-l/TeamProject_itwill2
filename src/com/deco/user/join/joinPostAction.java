package com.deco.user.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.Action;
import com.deco.ActionForward;

public class joinPostAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		
		
		ActionForward forward = new ActionForward("", true);
		return forward;
	}
	
}
