package com.deco.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.deco.Controller;
/*
@WebServlet("/notice/*")
public class TestController extends Controller{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setInit(req, res);
		keyword = getKeyword(req,7);
		
		if(keyword.equals("/list")){
			System.out.println("/list에 들어옴");
			
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
		keyword = getKeyword(req,6);
		
		if(keyword.equals("/list")){
			System.out.println("/list  ====> post 에 들어옴");
			
			try {
				forward = action.execute(req,res);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		
		render(forward,req,res);
	}
	
}
*/