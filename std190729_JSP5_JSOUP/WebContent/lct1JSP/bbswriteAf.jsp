<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>come</h1>
<%
	//title 있는지 검사
	if( request.getParameter("inputTitle") != null ){
		//content 있는지 검사
		if( request.getParameter("inputContent") != null ){
			System.out.println("yes param");
			
			String title = request.getParameter("inputTitle");
			String content = request.getParameter("inputContent");
			String id = ( (MemberDto)session.getAttribute("login") ).getId();
			
			if( title.length() < 1 ){
				System.out.println("no title");
				response.sendRedirect("./bbswrite.jsp");				
			}
			
			BbsDto dto = new BbsDto(id, title, content);
			
			int isDone = BbsDao.getInstance().insertBbs(dto);
			
			if( isDone == 0 ){
				response.sendRedirect("./bbswrite.jsp");	
			}else{
				response.sendRedirect("./bbslist.jsp");	
			}
			
			out.println("title : " + title);
			out.println("content : " + content);
			
		}else{
			System.out.println("no param");
		}
	}
%>
</body>
</html>