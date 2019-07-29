<%@page import="com.dao.CoffeeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//중복되었다? false, 중복이 아니다? true
	boolean canbeused = false;
	
	String[] idAndPw = null;
	String inputId = null;
	
	//id가 넘어왔으면? id검사
	if( request.getParameter("id") != null ){
		inputId = request.getParameter("id");
		
		idAndPw = CoffeeDAO.getInstance().getOneMamberInfo(inputId);
		
		//DB에서 가져온 값이 있으면? 중복됨
		if(idAndPw != null){
			
		}else{//DB에 해당 아이디가 없으면? 사용가능
			canbeused = true;
		}
	}
%>
<%=canbeused %>