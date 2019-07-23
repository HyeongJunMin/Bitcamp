<%@page import="model.dto.Human"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../index.jsp">Go To Home</a><br/>
<a href="./lct1JSP1.jsp">lecture 1-1 JSP inner object, scriptlet</a><br/>
<a href="./lct1JSP2.jsp">lecture 1-2 JSP </a><br/>
<a href="./lct1JSP3.jsp">lecture 1-3 JSP inner object(2)</a><br/>
<a href="./lct1JSP4.jsp">lecture 1-4 JSP link to other page</a><br/>

<h2>Lecture 1-2 JSP </h2>
 scriptlet 구성 : 선언부(선언), 코드부(표현), value부(표현)<br><br>
<%!
	//선언부 시작 표현 : <%!
	//이 페이지의 전역변수가 됨. 현재 페이지에 머무르는 동안 변수 유지 
	int globalVar = 0;
	class MyClass1{
		private int num; private String name; 
		public MyClass1(int a, String b){ this.num = a; this.name=b;}
		public String toString() { return "num: " + num + ", name: " + name ; }
	}
	public String f1(){ return "call f1";}
%>
<%
	//코드부
	globalVar++;
	out.println("glvar : " + globalVar);
	
	int localVar = 0;
	localVar++;
	out.println("var : " + localVar);
%>
<h1>선언부 내용 확인</h1>
<%
	MyClass1 mcls = new MyClass1(5,"gg");
	out.println(mcls.toString() + "<br/>");
	out.println("custum method in this jsp : " + f1() + "<br/>");
	Human h1 = new Human(3, "dd");
	out.println("dto with lombok : " + h1.toString() + "<br/>");
%>
</body>
</html>