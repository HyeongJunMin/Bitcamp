<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
int age = Integer.parseInt( request.getParameter("age") );
String address = request.getParameter("address");

System.out.println("name:" + name + " age:" + age + " address:" + address);
%>