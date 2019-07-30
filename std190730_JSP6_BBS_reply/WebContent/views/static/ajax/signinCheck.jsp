<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dao.impl.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("inputId");
	String pw = request.getParameter("inputPw");
	
	boolean isRightAccount = false;
	
	MemberDAOImpl dao = new MemberDAOImpl();
	MemberDTO dto = dao.selectOneMember(id);
	
	if(dto != null){
		if( pw.equals( dto.getPwd() ) ){
			session.setAttribute("currId", id);
			isRightAccount = true;
		}
	}
	
	
	
	String json = "{";  
	json += " \"result\" : " + isRightAccount;
	json += "}";
%>

<%=json %>