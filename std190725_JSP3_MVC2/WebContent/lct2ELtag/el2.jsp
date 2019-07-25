<%@page import="java.util.ArrayList"%>
<%@page import="com.model.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Core tag(JSTL.jar, standard.jar)</h3>
<%request.setAttribute("_data", "JSTL입니다"); %>
<p>${_data }</p>
<c:set var="_cdata" value="coreJSTL입니다"/>
<p>${_cdata }</p>var:value랑 setAttribute(name:value)랑 똑같음<br>
<c:out value="${_cdata }"/>

<!-- sessionData -->
<%session.setAttribute("sessionData", "저장된데이터"); %>
<c:set var="sdata" value="${sessionData }"/>
<c:out value="${sdata }"/>

<!-- 조건문 if -->
<%request.setAttribute("count", 10);
	int sCount = Integer.parseInt( request.getAttribute("count") + "");	%>
<p>test 안에 조건이 들어감</p>
<c:if test="${count >= 10 }">
	count:<c:out value="${count }"/>
</c:if>
<br><br>

<c:set var="name" value="ggg"></c:set>
<c:if test="${name eq 'ggg' }">
	ok ggg
</c:if>
<br>
조건문의 결과를 flg에 저장
<c:if test="${name == 'ggg' }" var="flg"></c:if>
<c:out value="${flg }"></c:out>

<br><br>
<c:forEach begin="0" end="9" step="1" varStatus="i">
	<c:out value="${i.index }"></c:out>
</c:forEach>

<br><br>
<%List<UserDTO> lst = new ArrayList<UserDTO>(); 
	lst.add(new UserDTO("1","11","111"));
	lst.add(new UserDTO("2","22","222"));
	lst.add(new UserDTO("3","33","333"));
	request.setAttribute("lst_user", lst);
%>
<c:forEach var="user11" items="${lst_user }" varStatus="i">
index : <c:out value="${i.index }"/>
data : <c:out value="${user11.name }: ${user11.id }"/>
</c:forEach>
</body>
</html>



