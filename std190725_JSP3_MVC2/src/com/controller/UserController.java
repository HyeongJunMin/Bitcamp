package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dao.UserDAO;
import com.model.dto.UserDTO;

public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO dao = UserDAO.getInstance();
		String command = req.getParameter("command");
		
		if(command == null) {
			command = "list";
		}
		
		System.out.println("usercontroller recv doGet, command : " + command);
				
		if( "list".equals(command) ) {//명령이 command인 경우
			try {
				
				List<UserDTO> list = dao.getUserList();
				req.setAttribute("userlist", list);
				req.getRequestDispatcher("userlist.jsp").forward(req, resp);
				
			} catch (SQLException e) {	System.out.println("exception at com.UserController");	}
		}else if( "adduser".equals(command) ) {
						
			String id = req.getParameter("inputId");
			String name = req.getParameter("inputName");
			String address = req.getParameter("inputAddr");

			UserDTO dto = new UserDTO(id, name, address);
			
			try {
				dao.addUser(dto);
				req.setAttribute("userlist", dao.getUserList());
				req.getRequestDispatcher("userlist.jsp").forward(req, resp);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.getRequestDispatcher("userlist.jsp").forward(req, resp);
		}else if( "userdetail".equals(command)) {
			if( req.getAttribute("modifyDone") == null ) {//수정 전
				req.getRequestDispatcher("userdetail.jsp?id=" + req.getParameter("id")).forward(req, resp);
			}else{//수정 완료
				req.setAttribute("modifyDone", req.getAttribute("modifyDone"));
				req.setAttribute("modifiedDTO", req.getAttribute("modifiedDTO"));
				req.getRequestDispatcher("userdetail.jsp").forward(req, resp);
				req.getRequestDispatcher("userdetail.jsp?id=" + req.getParameter("id")).forward(req, resp);
			}			
		}else if( "search".equals(command) ) {
			System.out.println("search ok");
			String searchOption = req.getParameter("serchOption");
			String searchTxt = req.getParameter("searchTxt");
			
			List<UserDTO> lst = null;
			try {
				lst = dao.search(searchOption, searchTxt);
			} catch (SQLException e) {	e.printStackTrace();	}
			
			for(UserDTO dto : lst){
				System.out.println(dto.toString() + "<br/>");
			}
			
			
			if(lst.size() > 0 ) {
				req.setAttribute("searchResult", lst);
//				response.sendRedirect("userlist.jsp");
				req.getRequestDispatcher("userlist.jsp").forward(req, resp);
			}else{
				req.setAttribute("searchResult", null);
				req.getRequestDispatcher("userlist.jsp").forward(req, resp);
			}
		}
			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO dao = UserDAO.getInstance();		
		String command = req.getParameter("command");
		
		System.out.println("usercontroller recv doPost, command : "  + command);
		
		if( command == null ) {
			this.doGet(req, resp);
		}
		if( "muldel".equals(command) ) {
			
			String[] users = req.getParameterValues("delck");;
			
			try {	
				dao.delUser(users);
				List<UserDTO> list = dao.getUserList();
				req.setAttribute("userlist", list);
				req.getRequestDispatcher("userlist.jsp").forward(req, resp);				
			} catch (SQLException e) {	System.out.println("exception at com.UserController");	}
		}
	}

}
