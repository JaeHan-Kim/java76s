<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>동영상 추가</title>
<meta charset='UTF-8'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/button.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/Header.jsp" />
	<form action='add.do' method='post' role="form"
		enctype="multipart/form-data">
		<h1>새 글</h1>
		<div class="container">
			
			<div class="form-group has-warning">
				<label for="usr">제목 :</label> 
				<input type="text" class="form-control" name="title">
			</div>
			
			<div class="form-group has-success">
				<label for="pwd">내용 :</label>
				<textarea class="form-control" rows="5" name='content'
					placeholder="상세계획을 입력하세요."></textarea>
			</div>
			
			<div class="form-group has-primary">
				<label for="file">동영상:</label> 
				<input type="file" class="form-control" name="video">
			</div>


		</div>


		<p>
			<button type='submit' class="button button3">등록</button>
		</p>

	</form>

	<footer class="container-fluid text-center">
		<jsp:include page="/Copyright.jsp" />
	</footer>
</body>
</html>
