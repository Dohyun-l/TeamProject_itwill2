package com.deco.share;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.ActionForward;
import com.deco.Controller;

// http://localhost:8088/TeamProject_itwill2/shareInfo/
@WebServlet("/shareInfo/*")
public class ShareController extends Controller{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setInit(req, res);
		keyword = getKeyword(req,10);
		
		
		
		
		if (keyword.equals("/shareWrite")){
			System.out.println("C : /shareWrite 호출");
			forward = new ActionForward("../share/writeShare.jsp", false);
		} else if(keyword.equals("/shareWriteAction")){
			System.out.println("C : /shareWriteAction 호출");
			action = new shareWriteAction();
			forward = action.execute(req, res);
		}
		
		
		if(forward != null){
			if(forward.isRedirect()){
				res.sendRedirect(forward.getURL());
				System.out.println("C : sendRedirect() 방식, " + forward.getURL() + "페이지 이동");
			}else{ //false
				System.out.println(forward.getURL());
				RequestDispatcher dis = req.getRequestDispatcher(forward.getURL());
				
				dis.forward(req, res);
				System.out.println("C : forward() 방식, " + forward.getURL());
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setInit(req, res);
		keyword = getKeyword(req,10);
		
		
		
		if(keyword.equals("/shareWriteAction")){
			System.out.println("C : /shareWriteAction 호출");
			action = new shareWriteAction();
			forward = action.execute(req, res);
		}
		
		
		if(forward != null){
			if(forward.isRedirect()){
				res.sendRedirect(forward.getURL());
				System.out.println("C : sendRedirect() 방식, " + forward.getURL() + "페이지 이동");
			}else{ //false
				System.out.println(forward.getURL());
				RequestDispatcher dis = req.getRequestDispatcher(forward.getURL());
				
				dis.forward(req, res);
				System.out.println("C : forward() 방식, " + forward.getURL());
			}
		}
		
		
	}
	
}
