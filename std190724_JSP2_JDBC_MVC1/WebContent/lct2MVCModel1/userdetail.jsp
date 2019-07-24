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
	String id = "";
	UserDTO dto = new UserDTO(" "," "," ");
	if( request.getParameter("id") != null){
		id = request.getParameter("id");
		dto = UserDAO.getInstance().getUser(id); 
	}else if( request.getAttribute("modifiedDTO") != null ){
		dto = (UserDTO)request.getAttribute("modifiedDTO");
	}
	
	out.println(dto.toString());
%>
<form action="./moduser.jsp">
<br><br>
ID : <input type="text" name="userId" value="<%=dto.getId() %>" readonly="readonly">
<br>
NAME : <input type="text" name="userName" value="<%=dto.getName() %>">
<br>
ADDR : <input type="text" name="userAddr" value="<%=dto.getAddress() %>">
<br>
<input type="submit" value="수정">
</form>
<% 	
	String msg="";
	if( request.getAttribute("modifyDone") != null ){
		msg = "수정 완료!";
		request.setAttribute("modifyDone", null);
	}else{
		msg = "";
	}
%>
<p><%=msg %></p>
<a href="./userlist.jsp">돌아가기</a>
</body>
</html>