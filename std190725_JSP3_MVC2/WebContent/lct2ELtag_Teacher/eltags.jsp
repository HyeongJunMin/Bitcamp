<%@page import="com.model.dto.MemberDto"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
	<%! function, variable    %>

	<% %> script + applet = scriptlet(java영역)
		  jsp(html + java)
		  
	<%=value %>
	
	EL(값) + Core(제어문) => java
	
	Expression Language	-> EL	  			
	표현(식)	      언어	 
	Core Tag	
	Jsp Tag
	
	JSTL(Java server page Standard Tag Language)	
 --%>

<%
	String str = "hello";
	request.setAttribute("_str", str);
%> 

<%
	String s = (String)request.getAttribute("_str");
%>
 
<%
out.println("s = " + s);
%> 
<br><br>

s = <%=s %>
<br><br>

<!-- EL -->
s = ${ _str }
<br><br>

<%='값' %>
<br>
${'값' }
<br>

<%=2+3 %>
<br>
${2+3 }

<br><br>

${3>2?100:200 }

<br><br>
<%
request.setAttribute("data", "안녕");
%>

${data }

<br><br>

변수(Object)의 data가 있는지?(null?)
<br>

data = ${empty data }		<!-- data == null -> true -->
<br>
data = ${not empty data }	<!-- data != null -> true -->
<br><br>

1 < 9 : ${1 < 9 }		<!-- true/false -->
<br>
2 + 3 : ${2 + 3 }		<!-- value -->
<br><br>

<%
Integer a, b;
a = 10;
b = 3;

request.setAttribute("_a", a);
request.setAttribute("_b", b);

Boolean c;
c = false;

request.setAttribute("_c", c);
%>

<pre>

a:${_a }
b:${_b }
c:${_c }

a+b:${_a + _b }

eq:${_a eq _b }
eq:${_a == _b }

ne:${_a ne _b }
ne:${_a != _b }

gt:${_a gt _b }
gt:${_a > _b }

lt:${_a lt _b }
lt:${_a < _b }

le:${_a le _b }		<!-- <= -->
ge:${_a ge _b }		<!-- >= -->

div:${_a div _b }	<!-- _a / _b -->
mod:${_a mod _b }	<!-- _a % _b -->

c:${!_c }

${_a == 10 && !_c }

</pre>

<br>
<%
MemberDto mem = new MemberDto();
mem.setMessage("Hello EL");

request.setAttribute("_mem", mem);
%>

<%=mem.getMessage()	%>
<br>

${_mem.message }
<br><br>

<%
String array[] = { "hello", "world" };

request.setAttribute("_array", array);
%>

<%=array[0] %>
<br>
${_array[1] }

<br><br>

<%
List<String> list = new ArrayList<>();
list.add("world");
list.add("EL");

request.setAttribute("_list", list);
%>
<%=list.get(0) %>
<br>

${_list[1] }
<br><br>

<%
List<MemberDto> memlist = new ArrayList<>();

MemberDto m = new MemberDto();
m.setMessage("메시지 one");
memlist.add(m);

m = new MemberDto();
m.setMessage("메시지 two");
memlist.add(m);

request.setAttribute("_memlist", memlist);
%>

<%=memlist.get(0).getMessage() %>
<br>
${_memlist[1].message }

<%
HashMap<String, String> map = new HashMap<>();

map.put("apple", "사과");
map.put("grape", "포도");

request.setAttribute("_map", map);
%>

${_map.apple }
<br>
${_map.grape }
<br>
${_map["apple"] }

</body>
</html>





