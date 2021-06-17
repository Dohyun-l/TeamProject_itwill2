package com.deco.user.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deco.Controller;

@WebServlet("*.json")
public class dataController extends Controller{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setInit(req, res);
		System.out.println(keyword);
		
		if(keyword.equals("/SearchUserEmail.json")){
			action = new 
		}else if(keyword.equals("/SearchUserNickname.json")){
			
		}
	}
	
}
