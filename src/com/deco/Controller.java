package com.deco;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
	
	protected void render(ActionForward forward, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		if(forward == null)
			return;
		
		if(forward.isRedirect()){
			res.sendRedirect(forward.getURL());
			System.out.println("C : sendRedirect() 방식, " + forward.getURL() + "페이지 이동");
			return;
		}

		RequestDispatcher dis = req.getRequestDispatcher(forward.getURL());
		dis.forward(req, res);
		System.out.println("C : forward() 방식, " + forward.getURL());
	}
}
