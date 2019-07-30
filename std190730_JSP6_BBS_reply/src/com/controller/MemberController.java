package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.dto.MemberDTO;
import com.service.impl.MemberServiceImpl;

public class MemberController extends HttpServlet{
		
	//Controller call url
	//http://localhost:8090/std190730_JSP6_BBS_reply/member
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Member Controller] do get");
		
		MemberServiceImpl service = new MemberServiceImpl();
		
		//명령어가 있는 경우
		if( req.getParameter("command") != null ) {
			String command = req.getParameter("command");
			
			//명령어 signinchk id 받아서 계정정보 리턴
			if( command.equals("signinchk") ) {
				boolean isRightAccount = false;
				
				String inputId = req.getParameter("inputId").toString();
				String inputPw = req.getParameter("inputPw").toString();
				
				MemberDTO dto = service.selectOneMember(inputId);
				
				//service를 통해 얻은 dto가 null이 아니고, pw도 일치하면 true를 리턴하고 session에 id저장
				if( dto != null ) {
					if( inputPw.equals(dto.getPwd()) ) {
						isRightAccount = true;
						req.getSession().setAttribute("currId", inputId);
					}
				}				
				resp.getWriter().print(isRightAccount);
			}
		}
		//명령어가 없으면 index page로 이동
		else {
			resp.sendRedirect("http://localhost:8090/std190730_JSP6_BBS_reply/bbs?command=showbbslist");			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Member Controller] do post");
	}

}
