<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.model.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL tag 1</h3>
<a href="./index.html">Go to home</a><br>
<%
	String str = "gi";
	request.setAttribute("_str", str);
%>

<%
	String str2 = request.getAttribute("_str") + "";
	out.println(str2);
%>
<br>
<p>str2 = <%=str2 %></p>
<p>str2 = ${_str}</p>

일반 문자


<br><br>
계산
<%=2+3 %> &nbsp;&nbsp;&nbsp;
${2+3 }

<%request.setAttribute("_mem", new UserDTO("1", "2", "3") );%>
${_mem.id}
${_mem.name}
${_mem.address}
<br><br>
<% String[] arr = {"12312", "345456"}; 
	request.setAttribute("_arr", arr);%>
${_arr[0] }
${_arr[1] }

<%
	List<String> lst = new ArrayList<String>();
	lst.add("123123123");
	lst.add("xcvxcv");
	request.setAttribute("_lst", lst);
%>
${_lst[0] } ${_lst[1] }


<%	
	List<UserDTO> lst2 = new ArrayList<>();
	lst2.add(new UserDTO("3","33","333"));
	request.setAttribute("_lst2", lst2);
%>
${_lst2[0].id}
</body>
</html>