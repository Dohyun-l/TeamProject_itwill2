package com.deco.user.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deco.Action;
import com.deco.ActionForward;



public class UserLoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		userDAO udao = new userDAO();
		int check = udao.login(email, pw);
		
		if(check == 0){
			PrintWriter out;
			out = res.getWriter();
			
			out.print("<script>");
			out.print("alert('비밀번호 오류.');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			
			return null;
		}else if(check == -1){
			PrintWriter out = res.getWriter();
			out.print("<script>");
			out.print("alert('비회원입니다.')");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			
			return null;
		}
		
		HttpSession session = req.getSession();
		ActionForward forward = new ActionForward("./Main.me",true);
		
		return forward;
	}

	
}
