<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String tName = request.getParameter("tname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HR Table</h1>

<pre>
SELECT * FROM <%=tName %>
지정 테이블의 데이터를 출력.
</pre>

<%
	//드라이버 존재여부 확인
	Class.forName("oracle.jdbc.driver.OracleDriver");

	//사용할 정보 취득 : DB perspective -> New Oracle(Database Connections) -> Properties
	String url = "jdbc:oracle:thin:@192.168.0.29:1521:xe";
	String user = "hr";
	String pass = "hr";
			
	Connection con = DriverManager.getConnection(url, user, pass);
	tName = (tName == null || tName.equals("")) ? "TAB" : tName.toUpperCase();
	
	String sql = " SELECT * FROM " + tName + " ORDER BY SEQ DESC ";
	
	PreparedStatement psmt = con.prepareStatement(sql);
	
	ResultSet rs = psmt.executeQuery();
	
	//컬럼 정보 취득
	ResultSetMetaData rsmd = rs.getMetaData();
	int countCol = rsmd.getColumnCount();
%>

<table border="1">
<tr>
	<%
		for(int i = 1 ; i < (countCol + 1) ; i++){
			out.println("<td>" + rsmd.getColumnName(i) + "</td>");
		}
	%>
</tr>
	<%
		while( rs.next() ){
			out.println("<tr>");
			for(int i = 1 ; i < (countCol + 1) ; i++ ){
				out.println("<td>");
				out.println(rs.getString(i));
				out.println("</td>");
			}
			out.println("</tr>");
		}
	%>
</table>

<%
	if(rs != null) rs.close();
	if(psmt != null) psmt.close();
	if(con != null) con.close();
%>
</body>
</html>