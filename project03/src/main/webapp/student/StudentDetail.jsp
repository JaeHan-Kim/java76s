<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<title>학생 - 상세정보</title>
</head>
<body>
<h1> 학생 정보 </h1>
<c:if test="${not empty student}">
<form id ='form1' action='update' method="post">
<table border="1">
<tr>
<th>Email</th>
<td><input type="text" name="email" value="${student.email}" readonly></td>
</tr>
<tr>
<th>Name</th>
<td><input type="text" name="name" value="${student.name}"></td>
</tr>
<tr>
<th>Tel</th>
<td><input type="text" name="tel" value="${student.tel}"></td>
</tr>
<tr>
<th>Cid</th>
<td><input type="text" name="cid" value="${student.cid}"></td>
</tr>
</table>
<p>
<button name="update" type="submit">변경</button>
<button name="delete" type="submit" onclick="deleteStudent()">삭제</button>
</p>
<script>
	function deleteStudent() {
		document.getElementById('form1').action ='delete';
	}
</script>
</form>
</c:if>
<c:if test="${empty student}">
 해당 이메일의 학생은 존재하지 않습니다.
</c:if>
<jsp:include page="/Copyright.jsp"/>
</body>

</html>