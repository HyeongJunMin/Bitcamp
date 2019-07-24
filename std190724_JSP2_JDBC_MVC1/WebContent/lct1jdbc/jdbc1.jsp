<%@page import="oracle.net.aso.r"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../">go to home</a>

<h3>SELECT * FROM TAB</h3>
<%!
	public boolean has$(String msg){
		return msg.contains("$");//$문자를 포함하는 임시테이블을 구분하기 위함
	}
%>
<%
	//드라이버 존재여부 확인
	Class.forName("oracle.jdbc.driver.OracleDriver");

	//사용할 정보 취득 : DB perspective -> New Oracle(Database Connections) -> Properties
	String url = "jdbc:oracle:thin:@192.168.0.29:1521:xe";
	String user = "hr";
	String pass = "hr";
	//모든 테이블 정보를 다 가져옴
	String sql = " SELECT * FROM TAB "; 
			
	Connection con = DriverManager.getConnection(url, user, pass);
		
	PreparedStatement psmt = con.prepareStatement(sql);
	
	ResultSet rs = psmt.executeQuery();
	
	//컬럼 정보 취득
	ResultSetMetaData rsmd = rs.getMetaData();
	int countCol = rsmd.getColumnCount();
%>

<table border="1">
	<tr>
		<%
			for(int i = 1 ; i < (countCol + 1) ; i++ ){
		%>
			<td><%=rsmd.getColumnName(i) %></td>	
		<%	
			}
		%>
	</tr>
	<%
		while( rs.next() ){ 
	%>
		<tr>
			<%
				for(int i = 1 ; i < (countCol+1) ; i++ ){
					String cols = rs.getString(i);
					if( i == 1 && has$(cols) == false ){//정상테이블인 경우(임시X)
				%>
					<td>
						<a href="./tableinfo.jsp?tname=<%=cols %>"><%=cols %></a>
					</td>					
				<%						
					}else{
				%>
					<td>
						<%=rs.getString(i) %>
					</td>										
				<%	
					}
				}
			%>
		</tr>
	<%
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