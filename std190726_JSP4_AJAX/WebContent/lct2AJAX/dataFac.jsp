<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//DB내용 가져오기
	String userName = "홍길동";
	int userNumber = 1001;
	
	String json = "{\"num\":" + userNumber + ", " + "\"name\":\"" + userName + "\"}";	
%>
<%=json %>
