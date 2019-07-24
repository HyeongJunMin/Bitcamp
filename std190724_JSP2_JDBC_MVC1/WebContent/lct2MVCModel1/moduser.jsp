<%@page import="com.model.UserDAO"%>
<%@page import="com.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("userId");
	String name = request.getParameter("userName");
	String addr = request.getParameter("userAddr");
	
	UserDTO dto = new UserDTO(id, name, addr);
	out.println(dto.toString());
	
	UserDAO.getInstance().modUser(dto);
	
	request.setAttribute("modifyDone", "ok");
	request.setAttribute("modifiedDTO", dto);
	request.getRequestDispatcher("userdetail.jsp").forward(request, response);
%>
</body>
</html>