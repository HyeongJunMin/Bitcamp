<%@page import="com.model.dao.UserDAO"%>
<%@page import="com.model.dto.UserDTO"%>
<%@page import="java.util.List"%>
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
	String searchOption = request.getParameter("serchOption");
	String searchTxt = request.getParameter("searchTxt");
	
	List<UserDTO> lst = UserDAO.getInstance().search(searchOption, searchTxt);
	
	for(UserDTO dto : lst){
		out.println(dto.toString() + "<br/>");
	}
	
	
	if(lst.size() > 0 ) {
		request.setAttribute("searchResult", lst);
//		response.sendRedirect("userlist.jsp");
		request.getRequestDispatcher("userlist.jsp").forward(request, response);
	}else{
		request.setAttribute("searchResult", null);
		request.getRequestDispatcher("userlist.jsp").forward(request, response);
	}
%>
</body>
</html>