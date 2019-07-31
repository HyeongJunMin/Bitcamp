package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BbsDTO;
import com.service.BbsService;
import com.service.impl.BbsServiceImpl;

public class BbsController extends HttpServlet{

	//BbsController call url
	//http://localhost:8090/std190730_JSP6_BBS_reply/bbs
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Bbs Controller] do get");
		
		BbsServiceImpl service = new BbsServiceImpl();
		
		//명령어가 있는 경우
		if( req.getParameter("command") != null ) {
			String command = req.getParameter("command");
			
			//명령어 showbbslist DB에서 게시물을 List형태로 불러와서 뷰로 전달
			if( command.equals("showbbslist") ) {
				System.out.println("[Bbs Controller] show bbs list");
				
				List<BbsDTO> lst =  service.getBbsList();
				req.setAttribute("bbslist", lst);
				req.getRequestDispatcher("/views/freeboard/freeboardmain.jsp").forward(req, resp);
				return;
				
			//명령어 writenewpost 새 글 DB에 저장
			}else if( command.equals("writenewpost") ) {
				//System.out.println("[Bbs Controller] write new post");
				
				String inputId = req.getParameter("id");
				String title = req.getParameter("inputTitle");
				String content = req.getParameter("inputContent");
				
				BbsDTO dto = new BbsDTO(inputId, title, content);
				
				service.writeNewPost(dto);
				System.out.println("[Bbs Controller] write new post DONE!");

				resp.sendRedirect("http://localhost:8090/std190730_JSP6_BBS_reply/bbs?command=showbbslist");
				return;
			
			//글 1개 상세보기
			}else if( command.equals("showonepost") ) {
				resp.setContentType("text/plain");
			    req.setCharacterEncoding("utf8");
			    resp.setCharacterEncoding("utf8");
			       
				int seq = Integer.parseInt(req.getParameter("seqNum") + "");
				
				BbsDTO dto = service.selectOnePost(seq);

				resp.getWriter().write(dto.toJson());
				
			//검색조건에 맞는 검색어 구하기
			}else if( command.equals("searchpost") ) {
				//검색참고
				//http://localhost:8090/190724/lct2MVCModel1/searchuser.jsp?serchOption=1&searchTxt=
				System.out.println("[Bbs Controller] do search post");
				
				String option = req.getParameter("option") + "";
				String condition = req.getParameter("condition") + "";
				
				//option, condition 확인
				System.out.println("option: " + option + "   , condition: " + condition);
				
				List<BbsDTO> lst = service.searchPosts(option, condition);
				//lst 확인
				System.out.println("lst size : " + lst.size());
				
				req.getSession().setAttribute("bbslist", lst);
				//req.setAttribute("searchResult", lst);
				//req.getRequestDispatcher("/views/freeboard/freeboardmain.jsp").forward(req, resp);
				resp.sendRedirect("http://localhost:8090/std190730_JSP6_BBS_reply/bbs?command=showbbslist");
				return;
			}
		}
		//명령어가 없으면 bbslist로 이동
		else {
			//System.out.println("[Bbs Controller] none");
			List<BbsDTO> lst =  service.getBbsList();
			req.getRequestDispatcher("/views/freeboard/freeboardmain.jsp").forward(req, resp);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Bbs Controller] do post");
	}
	
}
