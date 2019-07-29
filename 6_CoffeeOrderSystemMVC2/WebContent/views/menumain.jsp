<%@page import="com.dto.CoffeeMenuDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="./templates/header.jsp"></jsp:include>

<script type="text/javascript" src="./views/static/js/menumain.js"></script>
</head>
<body>
<%
	List<CoffeeMenuDTO> menuList = null;
	String currId = "";
	if( request.getAttribute("menuList") != null ){
		menuList = (List<CoffeeMenuDTO>)request.getAttribute("menuList");
	}
	if( request.getAttribute("currId") != null ){
		currId = request.getAttribute("currId") + "님 안녕하세요?";
	}
%>
<h6><%=currId %></h6>
<br>
<h3>가격표</h3>
<table>
	<tr>
		<th>No</th>
		<th>메뉴이름</th>
		<th>short</th>
		<th>tall</th>
		<th>grande</th>
	</tr>
	<%
		for(int i = 0 ; i < menuList.size() ; i++){
			out.println("<tr>");
			out.println("<td>" + menuList.get(i).getSeq() + "</td>");
			out.println("<td>" + menuList.get(i).getName() + "</td>");
			
			out.println("<td>");
			out.println("<input type=\"radio\" name=\"menusize\" value=\"" +
					menuList.get(i).getName() + "-short"
					+"\" > " + menuList.get(i).getPriceShort());
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"radio\" name=\"menusize\" value=\"" +
					menuList.get(i).getName() + "-tall"
					+"\" > " + menuList.get(i).getPriceTall());
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"radio\" name=\"menusize\" value=\"" +
					menuList.get(i).getName() + "-grande"
					+"\" > " + menuList.get(i).getPriceGrande());
			out.println("</td>");
			//out.println("<td>" + menuList.get(i).getPriceShort() + "</td>");
			//out.println("<td>" + menuList.get(i).getPriceTall() + "</td>");
			//out.println("<td>" + menuList.get(i).getPriceGrande() + "</td>");
			out.println("</tr>");
		}
	%>
</table>
<br><br>
<h3>옵션</h3>
<br>
	<table>
		<tr>
			<th>시럽</th>
			<th>샷 추가</th>
		</tr>
		<tr>
			<td><input type="radio" name="syrup" value="none" checked="checked">없음</td>
			<td><input type="radio" name="addshot" value="add" checked="checked">추가</td>
		</tr>
		<tr>
			<td><input type="radio" name="syrup" value="hazlenut">헤이즐넛</td>
			<td><input type="radio" name="addshot" value="none">추가안함</td>
		</tr>
		<tr>
			<td><input type="radio" name="syrup" value="caramel">카라멜</td>
			<td></td>
		</tr>
	</table>

</body>
</html>