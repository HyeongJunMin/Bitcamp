<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="100%" height="100%">
	<!-- header 영역 -->
	<tr align="center">
		<td height="10%" colspan="2">
			<tiles:insertAttribute name="header"/>
		</td>
	</tr>
	
	<!-- body 영역 -->
	<tr>
		<td width="30%" align="left" valign="top">
			<tiles:insertAttribute name="menu"/>
		</td>
		<td width="70%">
			<tiles:insertAttribute name="content"/>
		</td>
	</tr>
	
	<!-- footer 영역 -->
	<tr height="10%">
		<td colspan="2">
			<tiles:insertAttribute name="footer"/>
		</td>
	</tr>
</table>

</body>
</html>