<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = "abc";
	if( request.getParameter("id") != null ){
		String input = request.getParameter("id");
		if( id.equals( input ) ){
			id = "사용 불가";
		}else{
			id = "사용 가능";	
		}
		
	}
%>
<%=id %>