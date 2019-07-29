<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@page import="dao.iMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

iMemberDao dao = MemberDao.getInstance();

MemberDto mem = dao.login(new MemberDto(id, pwd, null, null, 0));

if(mem != null && !mem.getId().equals("")){
	session.setAttribute("login", mem);
	session.setMaxInactiveInterval(30*60*60);
%>
	<script>
	alert("안녕하세요 <%=mem.getName() %>님");
	location.href = "./bbslist.jsp";
	</script>
<%
}else{
%>
	<script>
	alert("ID나 Password를 확인하세요");
	location.href = "./login.jsp";
	</script>
<%
}
%>










