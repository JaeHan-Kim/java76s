<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset='UTF-8'>
<title>학생 - 목록</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>학생 목록</h1>
<p><a href="add.do">새 학생</a></p>
<table border="1">
<tr>
<th>Email</th>
</tr>
<c:forEach var="member" items="${members}">
<tr>
<td>${member.name}</td>
</tr>
</c:forEach>
</table>
<jsp:include page="/Copyright.jsp"/>
</body>

</html>