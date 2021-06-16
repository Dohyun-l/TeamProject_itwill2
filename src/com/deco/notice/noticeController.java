package com.deco.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.Controller;

@WebServlet("/notice/*")
public class noticeController extends Controller{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setInit(req, res);
		keyword = getKeyword(req,7);
		
		if(keyword.equals("/list")){
			System.out.println("/list");
			
			action = new deleteAction();
			forward = action.execute();
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
	
	}
	
}
