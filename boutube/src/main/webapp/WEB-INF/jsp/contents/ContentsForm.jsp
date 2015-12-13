<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Upload</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

.row.content {
	height: 450px
}

.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	<div class="container-fluid text-center">
		<div class="row content">
		<div id="wrapper" class="active">
	
			<div class="col-sm-8 text-left">
			
			<form action='add.do' method='post' role="form"
		enctype="multipart/form-data">
		<h1>Video Upload</h1>
		<div class="container">
			<div class="form-group has-warning">
				<label for="usr">Title :</label> 
				<input type="text" class="form-control" name="title">
			</div>
			<div class="form-group has-success">
				<label for="pwd">Contents :</label>
				<textarea class="form-control" rows="5" name='content'></textarea>
			</div>
			<div class="form-group has-primary">
				<label for="file">Video :</label> 
				<input type="file" class="form-control" name="videofile">
			</div>
		</div>
		<p>
			<button type='submit' class="btn btn-success">등록</button>
		</p>

	</form>

		</div>
	</div>
	</div>
			</div>
	<footer class="container-fluid text-center">
		<jsp:include page="/Copyright.jsp" />
	</footer>
</body>
</html>
