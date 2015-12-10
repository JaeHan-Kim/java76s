<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<title>회원 관리</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1> 회원 정보 </h1>
<c:if test="${not empty student}">
<form id ='form1' action='update.do' method="post" enctype="multipart/form-data">
<table border="1">
<tr>
<th>Picture</th>
<td><img width='200' height='300' 
      src='../file/${(empty student.pic)?"default.png":student.pic}' width="300" height="300"><br>
      <input type='file' name='photofile'>
      <input type='hidden' name='pic' value='${student.pic}'></td>
</tr>
<tr>
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
<button name="update" type="submit" class='button1'>변경</button>
<a href='delete.do?email=${student.email}' class='button2'>삭제</a>
</p>
</form>
</c:if>
<c:if test="${empty student}">
 해당 이메일의 학생은 존재하지 않습니다.
</c:if>
<jsp:include page="/Copyright.jsp"/>
</body>

</html>