package com.deco.user.join;

import com.deco.user.Action;
import com.deco.user.ActionForward;

public class joinAction implements Action{

	@Override
	public ActionForward execute() {
		ActionForward forward = new ActionForward("../user/join/join.jsp", false);
		return forward;
	}
}
