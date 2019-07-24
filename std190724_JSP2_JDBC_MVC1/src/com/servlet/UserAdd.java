package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;
import com.model.UserDAO;

@WebServlet("/lct2MVCModel1/adduser.do")
public class UserAdd extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok useradd get");
		
		String inputID = req.getParameter("inputId");
		String inputName = req.getParameter("inputName");
		String inputAddr = req.getParameter("inputAddr");
		
		UserDTO dto = new UserDTO(inputID, inputName, inputAddr);
		
		try {
			UserDAO.getInstance().addUser(dto);
		} catch (SQLException e) {
			System.out.println("sql exception in userAdd doGet");
		}
		
		req.getRequestDispatcher("/lct2MVCModel1/userlist.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
