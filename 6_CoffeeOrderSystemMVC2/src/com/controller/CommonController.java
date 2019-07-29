package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CoffeeDAO;
import com.dto.CoffeeMemberDTO;
import com.dto.CoffeeMenuDTO;

public class CommonController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[controller] Common doGet Ok");
		//coffee리스트(menumain.jsp) 접근 주소
		//http://localhost:8090/6_CoffeeOrderSystemMVC2/coffee
		
		CoffeeDAO dao = CoffeeDAO.getInstance();
		List<CoffeeMenuDTO> menuList = null;
		try {
			menuList = dao.getMenuList();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//command가 있을 때
		if( req.getParameter("command") != null ) {
			String command = req.getParameter("command");
			System.out.println("[controller] command OK command = " + command);
			
			if( command.equals("signinIdChk") ) {
				//signin view에서 넘어온 ID를 체크하고, menumain으로 이동
				String inputId = req.getParameter("inputIdInSigninView");
				String inputPw = req.getParameter("inputPwInSigninView");
				System.out.println("ID : " + inputId + ", PW : " + inputPw);
				
				String[] idAndPw = {"" , ""};
				try {
					idAndPw = dao.getOneMamberInfo(inputId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(inputId.equals(idAndPw[0])) {
					if( inputPw.equals(idAndPw[1]) ) {
						req.setAttribute("currId", inputId);
						req.setAttribute("menuList", menuList);
						req.getRequestDispatcher("/views/menumain.jsp").forward(req, resp);
						return;
					}else {
						resp.sendRedirect("/6_CoffeeOrderSystemMVC2/views/signinview.jsp");
						return;
					}	
				}else {
					resp.sendRedirect("/6_CoffeeOrderSystemMVC2/views/signinview.jsp");
					return;
				}								
			//command가 signup인 경우 회원가입 페이지로 이동
			}else if( command.equals("signup") ) {
				resp.sendRedirect("/6_CoffeeOrderSystemMVC2/views/signupview.jsp");
				return;
			//command가 signupdata인 경우 회원가입 처리하고 메인메뉴 뷰로 이동
			}else if( command.equals("signupdata") ) {
				
				String inputId = req.getParameter("txtId");
				String inputPw = req.getParameter("txtPw");
				String inputName = req.getParameter("txtName");
				
				dao.insertOneMember(new CoffeeMemberDTO(inputId, inputPw, inputName, 0, new Date(), 3));
				
				req.setAttribute("currId", inputId);
				req.setAttribute("menuList", menuList);
				req.getRequestDispatcher("/views/menumain.jsp").forward(req, resp);
				
				return;
			}else if( command.equals("menulist") ) {
				req.setAttribute("menuList", menuList);
				req.getRequestDispatcher("/views/menumain.jsp").forward(req, resp);
				return;
			}
		}
		//command가 없을 때 == 첫 접속
		else {
			System.out.println("[controller][indexpage] no command, go to signin view");
			//req.setAttribute("menuList", menuList);
			//req.getRequestDispatcher("/views/signinview.jsp").forward(req, resp);
			resp.sendRedirect("/6_CoffeeOrderSystemMVC2/views/signinview.jsp");
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Common doPost Ok");
	}
	
}
