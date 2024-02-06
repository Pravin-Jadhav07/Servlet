<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failed</title>
</head>
<body>
<h1>Registration Failed...</h1>
<% String name =(String) session.getAttribute("name"); %>
<h2>Hey <%= name %> your registration is failed...</h2>
</body>
</html>