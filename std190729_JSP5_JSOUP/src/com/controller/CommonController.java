package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonController extends HttpServlet{

	//servlet url : http://localhost:8090/std190729_JSP5_JSOUP/work
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Common Controller] ok do get!");
		
		//커맨드가 null이면 인덱스 페이지로 이동
		if( req.getParameter("command") == null) {
			resp.sendRedirect("../index.jsp");
			return;
		}else {
			String command = req.getParameter("command");
			
			//커맨드가 freeboard이면 freeboard main으로 이동
			if( command.equals("freeboard")) {
				System.out.println("ok freeboard !");
				//req.getRequestDispatcher("workMVC2/freeboardmain.jsp").forward(req, resp);
				resp.sendRedirect("./freeboardmain.jsp");
				return;
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Common Controller] ok do post!");
	}

}
