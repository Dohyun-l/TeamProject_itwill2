package com.deco.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.nt")
public class NoticeController extends HttpServlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : NoticeController_Process() 호출");
		
		/********************************** 1.페이지 주소 파싱 ********************************************/
		// 가상주소 전체 가져오기
		String requestURI = request.getRequestURI();
		// 프로젝트명 가져오기
		String contextPath = request.getContextPath();
		// 필요한 가상주소 생성
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("command : " + command);
		System.out.println("C : 1. 페이지 주소 파싱 완료");
		/********************************** 1.페이지 주소 파싱 ********************************************/
		
		
		/********************************** 2.페이지 주소 매핑(연결) ********************************************/

		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/Main.nt")){
			forward = new ActionForward();
			forward.setPath("./main/main.jsp");
			forward.setRedirect(false);
		}
		
		else if(command.equals("/noticeform.nt")){
			forward = new ActionForward();
			forward.setPath("./notice/edit.html");
			forward.setRedirect(false);
		}

		else if(command.equals("/noticelist.nt")){
			forward = new ActionForward();
			forward.setPath("./notice/list.jsp");
			forward.setRedirect(false);
		}

		else if(command.equals("/noticecontent.nt")){
			forward = new ActionForward();
			forward.setPath("./notice/content.jsp");
			forward.setRedirect(false);
		}
		else if(command.equals("/filedown.nt")){
			forward = new ActionForward();
			forward.setPath("./notice/file_down.jsp");
			forward.setRedirect(false);
		}
		//////////////////////////////////////////////////////
		
		
		else if(command.equals("/noticemodify.nt")){
			action = new NoticeModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		else if(command.equals("/NoticeInsertAction.nt")){
			System.out.println("2 : /NoticeInsertAction.nt 호출");
			action = new NoticeInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/NoticeDeleteAction.nt")){
			System.out.println("2 : ./NoticeDeleteAction.nt 호출");
			action = new NoticeDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/NoticeModifyAction.nt")){
			System.out.println("2 : ./NoticeModifyAction.nt 호출");
			action = new NoticeModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("C : 2. 페이지 주소 매핑 완료");
		/********************************** 2.페이지 주소 매핑(연결) ********************************************/
		
		
		/********************************** 3.페이지 주소 이동 ********************************************/
		if(forward != null){	// 페이지 이동정보가 있다.
			if(forward.isRedirect()){	// true
				response.sendRedirect(forward.getPath());
				System.out.println("C : sendRedirect() 방식, " + forward.getPath() + "페이지 이동");
			}else{	// false
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
				System.out.println("C : forward() 방식, " + forward.getPath() + "페이지 이동");
			}
			System.out.println("C : 3. 페이지 주소 이동 완료");
		}
		System.out.println("C : 3. 페이지 주소 이동 X (컨트롤러 이동 X)");
		/********************************** 3.페이지 주소 이동 ********************************************/
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : NoticeController_doGet() 호출");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : NoticeController_doPost() 호출");
		doProcess(request, response);
	}
	
	
	
	
}
