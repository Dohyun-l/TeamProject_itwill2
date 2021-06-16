package com.deco.user.join;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.deco.Controller;

@WebServlet("/users/*")
public class userController extends Controller{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setInit(req, res);
		keyword = getKeyword(req,6);
		
		if(keyword.equals("/join")){
			System.out.println("/join에 들어옴");
			
			action = new joinGetAction();
			forward = action.execute(req,res);
		}
		
		String hash = BCrypt.hashpw("1234", BCrypt.gensalt(5));
		System.out.println(hash);
		
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
		keyword = getKeyword(req,6);
		
		if(keyword.equals("/join")){
			System.out.println("/join  ====> post 에 들어옴");
			
			action = new joinPostAction();
			forward = action.execute(req,res);
		}
	}
	
}
