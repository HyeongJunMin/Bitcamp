<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<!-- Account view member -->
<%
	String id = "";
	if( session.getAttribute("currId") != null ){
		id = session.getAttribute("currId")+"";
	}
%>
<div id="mainAccountView">
		<!-- Button for open modal view Attribute : data-target, data-toggle-->
		<button id="btnMainSignin" type="button" class="btn btn-primary"
			data-toggle="modal" data-target="#signinModal">안녕하세요 <%=id %>님!</button>
		<!-- <input id="btnMainSignin" type="button" value="Sign in" onclick="echoTest()"> -->
		<br><br> 
		<a onclick="echoTest()" href="">My Page</a>	&nbsp;&nbsp;&nbsp;&nbsp; 
		<a href="http://localhost:8090/std190730_JSP6_BBS_reply/views/freeboard/sessionInval.jsp">EXIT</a>
</div>
</html>