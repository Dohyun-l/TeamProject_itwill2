package com.deco.user.join;

import com.deco.Action;
import com.deco.ActionForward;

public class joinAction implements Action{

	@Override
	public ActionForward execute() {
		ActionForward forward = new ActionForward("../user/join/join.jsp", false);
		return forward;
	}
}
