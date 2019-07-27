package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MemberController ok doGet");
		
		List<String> lst = new ArrayList<>();
		lst.add("11");
		lst.add("22");
		req.setAttribute("list", lst);
		
		//페이지코드가 null이 아닌 경우
		if( req.getParameter("pagecode") != null ) {
			String pagecode = req.getParameter("pagecode");
			
			//페이지코드가 index인 경우 index.jsp로 이동
			if( "index".equals(pagecode) ) {
				System.out.println("go to [index] by memberController if.if(index)");
				resp.sendRedirect("/std190726_JSP4_AJAX/index.jsp");
				
			//페이지코드가 userList인 경우 userlist.jsp로 이동해서 DB정보 show
			}else if( "userList".equals(pagecode) ){
				System.out.println("go to [userlist] by memberController if.elseif(userlist)");
				req.getRequestDispatcher("/MVC2ELtag/userlist.jsp").forward(req, resp);
				
			}else {
				System.out.println("go to [index] by memberController if.else");
				resp.sendRedirect("/std190726_JSP4_AJAX/index.jsp");				
				//resp.sendRedirect("/std190726_JSP4_AJAX/MVC2ELtag/userlist.jsp");
			}
			
		//페이지코드가 null인 경우
		}else {
			System.out.println("go to [index] by memberController else.");
			resp.sendRedirect("/std190726_JSP4_AJAX/index.jsp");				
			//resp.sendRedirect("/std190726_JSP4_AJAX/MVC2ELtag/userlist.jsp");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MemberController ok doPost");
	}
	
}
