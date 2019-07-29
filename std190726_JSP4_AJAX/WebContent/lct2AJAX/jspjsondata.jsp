<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String valA = request.getParameter("valA");
	String valB = request.getParameter("valB");
	String valJson = "{ \"valA\" : " + valA + ", \"valB\" : " + valB + " }";
%>

<%=valJson%>