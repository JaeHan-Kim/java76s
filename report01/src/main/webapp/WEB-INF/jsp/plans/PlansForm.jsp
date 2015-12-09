<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시판 - 새글</title>
</head>
<body>
	<h1>새 글</h1>
	<form action='add.do' method='post' enctype="multipart/form-data">
		<table border='1'>
			<tr>
				<th>계획</th>
				<td><input type='text' name='plan_title' placeholder="계획을 입력하세요."></td>
			</tr>
			<tr>
				<th>상세계획</th>
				<td><textarea rows='10' cols='60' name='plan_content'
						placeholder="상세계획을 입력하세요."></textarea></td>
			</tr>
			<tr>
				<th>D_day</th>
				<td><input type='date' name='d_day'></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="file"></td>
			</tr>
		</table>


		<p>
			<button type='submit'>등록</button>
		</p>
	</form>

	<jsp:include page="/Copyright.jsp" />

</body>
</html>
