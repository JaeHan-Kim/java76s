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
<h1>학생 목록</h1>
<p><a href="form.html">새 학생</a></p>
<table border="1">
<tr>
<th>Email</th>
<th>Name</th>
<th>Tel</th>
<th>Cid</th>
</tr>
<c:forEach var="student" items="${students}">
<tr>
<td>${student.email}</td>
<td><a href='update?email=${student.email}'>${student.name}</a></td>
<td>${student.tel}</td>
<td>${student.cid}</td>
</tr>
</c:forEach>
</table>
<jsp:include page="/Copyright.jsp"/>
</body>

</html>