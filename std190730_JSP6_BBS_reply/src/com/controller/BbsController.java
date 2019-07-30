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
			}else if( command.equals("searchpost") ) {
				int option = Integer.parseInt( req.getParameter("option") + "" );
			}
		}
		//명령어가 없으면 index page로 이동
		else {
			//System.out.println("[Bbs Controller] none");
			resp.sendRedirect("http://localhost:8090/std190730_JSP6_BBS_reply/views/freeboard/freeboardmain.jsp");			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Bbs Controller] do post");
	}
	
}
