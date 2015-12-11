<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생정보 - 새정보</title>
</head>
<body>
	<h1>학생 정보 등록</h1>
	<form id='form1' action='add.do' method='post'
		enctype="multipart/form-data">
		<table border='1'>
			<tr>
				<th>사진</th>
				<td><input type="file" name="photofile"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type='text' name='email'></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type='text' name='name'></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type='password' name='password'></td>
			</tr>
		</table>
		<p>
			<button type='submit'>추가</button>
	</form>
<jsp:include page="/Copyright.jsp" />

</body>
</html>