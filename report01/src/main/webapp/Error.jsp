<%@page import="java.io.PrintWriter"%>
<%@ page language="java" 
		contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>System Error</title>
</head>
<body>
<h1>System Error!</h1>
<pre>
<%
Exception e = (Exception)request.getAttribute("error");
e.printStackTrace(new PrintWriter(out));

%>
</pre>
</body>
</html>










