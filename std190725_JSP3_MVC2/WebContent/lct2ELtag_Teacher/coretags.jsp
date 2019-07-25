<%@page import="java.util.ArrayList"%>
<%@page import="com.model.dto.MemberDto"%>
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

<%--
	EL : 표현식(값), 비교(true/false)
	 
	Core : 제어문(for, if) -> EL과 같이 사용한다
 --%>

<%
request.setAttribute("_data", "JSTL입니다");
%>

${_data }
<br>

<!-- set -->
<c:set var="_cdata" value="core JSTL입니다"/>
${_cdata }
<br><br>

<!-- out == 내장객체 -->
<c:out value="${_cdata }"></c:out>
<br><br>

<!-- session -->
<%
session.setAttribute("sessionData", "저장된 데이터");
%>
<c:set var="sdata" value="${sessionData }"/>
<c:out value="${sdata }"/>
<br><br>

<!-- if -->
<%
request.setAttribute("count", "10");
%>

<%
String sCount = (String)request.getAttribute("count");
int count = Integer.parseInt(sCount);
if(count >= 10){
	%>
	count:<%=count %>
	<%
}
%>

<c:if test="${count >= 10 }">
	count:<c:out value="${count }"></c:out>
</c:if>

<br><br>

<%
request.setAttribute("name", "홍길동");
%>

<c:if test="${name eq '홍길동'}">
	이름은 홍길동 맞습니다
</c:if>

<%
request.setAttribute("name", "일지매");
%>

<c:if test="${name == '일지매' }" var="flg"/>

<c:if test="${!flg }">
	제 이름은 일지매입니다
</c:if>

<br><br>

<!-- for -->
<%
for(int i = 0;i < 10; i++){
	%>	
	<%=i %>	
	<%
}
%>
<br>
<c:forEach begin="0" end="9" step="1" varStatus="i">
	<c:out value="${i.index }"></c:out>
</c:forEach>

<br><br>

<%
List<MemberDto> list = new ArrayList<>();

MemberDto mem = new MemberDto();
mem.setMessage("하이");
list.add(mem);

mem = new MemberDto();
mem.setMessage("안녕");
list.add(mem);

mem = new MemberDto();
mem.setMessage("잘가");
list.add(mem);

request.setAttribute("_list", list);
%>

<%
for(int i = 0;i < list.size(); i++){
	MemberDto m = list.get(i);
}
for(MemberDto m : list){	
}
%>

<c:forEach var="m" items="${_list }" varStatus="i">
index:<c:out value="${i.index }"/>
data:<c:out value="${m.message }"/><br>
</c:forEach>









</body>
</html>





