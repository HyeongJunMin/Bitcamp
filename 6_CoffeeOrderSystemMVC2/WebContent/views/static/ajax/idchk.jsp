<%@page import="com.dao.CoffeeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	boolean ok = false;
	String inputId = request.getParameter("id");
	String inputPw = request.getParameter("pw");
	
	System.out.println(inputId + ",,,," + inputPw);
	
	String[] idAndPw = CoffeeDAO.getInstance().getOneMamberInfo(inputId);
	
	//DB에 ID가 있는지 검사
	if(idAndPw != null){
		//DB에 있는 PW와 일치
		if( idAndPw[1].equals(inputPw) ){
			System.out.println(idAndPw[0]+"...."+idAndPw[1]);	
			ok = true;			
		}
	}else{
		System.out.println("null");
	}
%>
<%=ok %>
