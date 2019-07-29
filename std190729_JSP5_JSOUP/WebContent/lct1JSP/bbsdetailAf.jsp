<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@page import="jdk.nashorn.internal.ir.debug.JSONWriter"%>
<%@page import="jdk.nashorn.internal.runtime.JSONFunctions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int isDone = 0;
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BbsDto inputDto = new BbsDto(seq, title, content);
	
	BbsDao.getInstance().updateBbs(seq, title, content);
			
	String str = "";
	
	//업데이트 성공한 경우 
	BbsDto dto = BbsDao.getInstance().getBbs(seq);
		
		str = "{  \"seq\":" + seq +  ", "
				+ "\"title\" :" + title +  "\", "
				+ "\"content\":\"" + content + "}";	

	
	
%>
<%=str %>