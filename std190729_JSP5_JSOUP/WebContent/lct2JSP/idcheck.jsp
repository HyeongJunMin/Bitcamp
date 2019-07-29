<%@page import="dao.MemberDao"%>
<%@page import="dao.iMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
System.out.println("id:" + id);

iMemberDao dao = MemberDao.getInstance();
boolean isS = dao.getId(id);

if(isS){
	out.println("NO");
}else{
	out.println("OK");
}

%>    






