<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@
	page import="java.util.Date"
 %>
 
<%!
	int age =23;

%>

<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	out.println("hey "+name);
	Date date = new Date();

%>
<h1>your name is <%= name %> <br> Email is <%=email %> <br> and your age is <%=age %></h1>
<br>
<h2>todays date is <%= date %></h2>

</body>
</html>