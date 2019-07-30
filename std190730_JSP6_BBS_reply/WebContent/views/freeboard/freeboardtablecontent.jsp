<%@page import="java.util.Enumeration"%>
<%@page import="com.dto.BbsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	
	List<BbsDTO> lst = null;
	//bbslist가 null이 아니면?
	if( request.getAttribute("bbslist") != null ){
		Object obj = request.getAttribute("bbslist");
		lst = (List<BbsDTO>)obj;
		
		for(BbsDTO dto : lst){
			out.println("<tr onclick=\"viewPostDetail("+ dto.getSeq() +"); \">");
			out.println("<td>");
			out.println(dto.getSeq());
			out.println("</td><td><a href=\"#\">");
			out.println(dto.getTitle());
			out.println("</a></td>");
			out.println("<td>");
			out.println(dto.getId());
			out.println("</td>");
			out.println("<td>");
			out.println(dto.getWdate().toString());
			out.println("</td>");		
			out.println("<td>");
			out.println(dto.getReadcount());
			out.println("</td>");
			out.println("</tr>");
		}
	}	
%>
</html>