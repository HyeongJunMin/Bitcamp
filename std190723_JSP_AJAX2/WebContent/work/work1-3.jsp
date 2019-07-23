<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String[] strColorStr = {"빨간", "파란", "녹"};
	String[] strColorCode = {"red", "blue", "green"	};
	
	String str2 = "색 텍스트";
	String[] colorText(){
		String[] arrOutput = new String[3];
		for(int i = 0 ; i < 3 ; i++){
			arrOutput[i] = "<p style=\"color:" + strColorCode[i] + "\">" + strColorStr[i] + str2 + "</p>";
		}
		return arrOutput;
	}
	
	//강사코드
	public String setColorHTML(String strSen, String color){
		return "<font color=\"" + color +"\">" + strSen + "</font>";
	}
	
	String styleStr = "style=\"color: red;\"";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../index.jsp">Go To Home</a><br/>
<a href="./work1-1.jsp">work1-1</a><br/>
<a href="./work1-2.jsp">work1-2</a><br/>
<a href="./work1-3.jsp">work1-3</a><br/>

<h2>메소드를 사용하는 예</h2>
<%
	String[] arrStr = this.colorText();
	for(String s : arrStr)
		out.println(s);
%>

<h3 <%=styleStr %>>강사 코드</h3>
<%
	String redText = setColorHTML("빨간 텍스트", "#ff0000");
%>
<p><%=redText %></p>
</body>
</html>