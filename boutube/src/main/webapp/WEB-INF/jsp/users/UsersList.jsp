<%-- EL을 이용하여 게시물 데이터 출력하기 --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
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
<th>Name</th>
</tr>
<c:forEach var="user" items="${users}">
<tr>
<td>
<%-- <img src='../file/s-${student.pic}'>--%>
 <img src='../file/s-${(empty users.photo)?"default":users.photo}.png'>
${users.email}</td>
<td><a href='detail.do?email=${users.email}'>${users.name}</a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="/Copyright.jsp"/>
</body>

</html>