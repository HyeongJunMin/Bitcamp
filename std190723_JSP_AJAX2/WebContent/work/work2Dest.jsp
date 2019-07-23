<%@page import="model.dto.WorkDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	String id = "";
	String pw = "";
	String[] hobby = {""};
	String age = "";
	String txt = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>전송된 정보</h3>
<%
	if( request.getAttribute("itsPost") == null ){//GET방식
		id = request.getParameter("inputId");
		pw = request.getParameter("inputPw");
		hobby = request.getParameterValues("hobby");
		age = request.getParameter("ages") + "대";
		txt = request.getParameter("gg");		
		out.println("ID : " + id);
		out.println("PW : " + pw);
		for(int i = 0 ; i < hobby.length ; i++){
			out.println("hobby" + (i+1) + ": " + hobby[i]);
		}		
		out.println("AGE : " + age);
		out.println("txt : " + txt); 
	}else{//POST방식
		WorkDTO dto = (WorkDTO)request.getAttribute("WorkDTO") ;
		id = dto.getId();
		pw = dto.getPw();
		hobby = dto.getHobby();
		age = dto.getAge();
		txt = dto.getTxt();
	}
%>

<p>ID : <%=id %></p>
<p>PW : <%=pw %></p>
<%	for(int i = 0 ; i < hobby.length ; i++)
		out.println("<p>hobby" + (i+1) + ": " + hobby[i] + "</p>"); %>
<p>AGE : <%=age %></p>
<textarea rows="5" cols="50"><%=txt %></textarea>
</body>
</html>