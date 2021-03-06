package com.deco.user.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.deco.Action;
import com.deco.ActionForward;


public class searchUserEmailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//post로 온 body를 받는 영역
		String postBody = getBody.readBody(req);

		JSONParser jsonParser = new JSONParser();
		JSONObject postBodyObject = (JSONObject) jsonParser.parse(postBody);

		String nowEmail = (String)postBodyObject.get("reqData");

		//DB 호출
		userDAO uDAO = new userDAO();
		boolean exists = uDAO.searchUserEmail(nowEmail);
		
		JSONObject state = new JSONObject();
		if(exists){
			state.put("exists", true);
		}else{
			state.put("");
		}
		
		return new ActionForward(req.getContextPath()+"/user/join/resultSearch.jsp", false);
	}
	
}
