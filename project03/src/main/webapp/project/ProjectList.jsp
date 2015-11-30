<%@ page language="java" 
		contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>프로젝트 목록</title>
</head>
<body>
<h1>프로젝트 리스트</h1>
<a href="form.html">새 글</a>
<table border='1'>
<tr>
	<th>No</th>
	<th>Title</th>
	<th>StartDate</th>
	<th>EndDate</th>
	<th>Members</th>
</tr>
<c:forEach var="project" items="${projects}">
<tr>
	<td>${project.no}</td>
	<td><a href='update?no=${project.no}'>${project.title}</a></td>
	<td>${project.startDate}</td>
	<td>${project.endDate}</td>
	<td>${project.member}</td>
</tr>
</c:forEach>
</table>
<jsp:include page="/Copyright.jsp"/>
</body>
</html>