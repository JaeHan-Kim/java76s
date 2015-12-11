<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>new Todo List</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="../css/button.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/Header.jsp"/>
	<form action='add.do' method='post' role="form" enctype="multipart/form-data">
    <h1>새 글</h1>
		<table border='1'>
			<tr>
				<th>제목</th>
								<td><input type='text' name='title'
				placeholder="제목을 입력하세요."></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows='10' cols='60' name='content'
							placeholder="내용을 입력하세요."></textarea></td>
			</tr>
			<tr>
 	<th>첨부파일</th>
 	<td><input type="file" name="video"></td>
 </tr>
		</table>
		
		
		<p><button type='submit'>등록</button></p>
	</form>
	<footer class="container-fluid text-center">
		<jsp:include page="/Copyright.jsp" />
	</footer>
</body>
</html>
