package com.deco;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{
	public String reqURI;
	public String keyword;
	public Action action;
	public ActionForward forward;
	
	protected void setInit(HttpServletRequest req, HttpServletResponse res){
		reqURI = req.getRequestURI();
		keyword = getKeyword(req, 0);
		action = null;
		forward = null;
	}
	
	protected String getKeyword(HttpServletRequest req, int length){
		return req.getRequestURI().substring(req.getContextPath().length()+length);
	}
}
