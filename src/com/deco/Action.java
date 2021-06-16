package com.deco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	abstract public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
