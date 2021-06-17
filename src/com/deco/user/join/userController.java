package com.deco.user.join;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.deco.Controller;

@WebServlet("*.us")
public class userController extends Controller{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setInit(req, res);
		
		if(command.equals("/join.us")){
			System.out.println("join에 들어옴");
			
			action = new joinGetAction();
			try {
				forward = action.execute(req,res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		render(forward,req,res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setInit(req, res);
		
		if(command.equals("/join.us")){
			System.out.println("/join  ====> post 에 들어옴");
			
			action = new joinPostAction();
			try {
				forward = action.execute(req,res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		render(forward,req,res);
	}
	
}
