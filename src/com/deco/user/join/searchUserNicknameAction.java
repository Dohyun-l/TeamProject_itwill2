package com.deco.user.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.deco.Action;
import com.deco.ActionForward;

public class searchUserNicknameAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String nowNickname = getBody.getReqData(req);

		//DB 호출
		userDAO uDAO = new userDAO();
		boolean exists = uDAO.searchUserNickname(nowNickname);
		
		JSONObject state = new JSONObject();
		if(exists){
			state.put("exists", true);
		}else{
			state.put("exists",false);
		}
		
		req.setAttribute("Exists", state);
		return new ActionForward("./user/join/resultSearch.jsp", false);
	}

}
