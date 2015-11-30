<%@ page language="java" 
		contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>프로젝트 - 상세정보</title>
</head>
<body>
<c:if test="${not empty project}">
<form id='form1' action = 'update' method="post">
<table border="1">
<tr>
<th>번호</th>
<td><input type='text' value='${project.no}' name='no' readonly/></td>
</tr>
<tr>
<th>시작날짜</th>
<td><input type='text' value='${project.startDate}' name='startDate'/></td>
</tr>
<tr>
<th>마감날짜</th>
<td><input type='text' value='${project.endDate}' name='endDate'/></td>
</tr>
<tr>
<th>프로젝트명</th>
<td><input type='text' value='${project.title}' name='title' /></td>
</tr>
<tr>
<th>조원</th>
<td><input type='text' value='${project.member}' name='member'/></td>
</tr>
</table>
<p>
<button name='update' type='submit'>변경</button>
<button name='delete' type='submit' onclick='deleteProject()'>삭제</button>
</p>
<script>
	function deleteProject() {
		document.getElementById('form1').action ='delete';
	}
</script>
</form>
</c:if>
<c:if test="${empty project}">
	해당 번호의 프로젝트을 찾을 수 없습니다.
</c:if>
</body>
</html>
