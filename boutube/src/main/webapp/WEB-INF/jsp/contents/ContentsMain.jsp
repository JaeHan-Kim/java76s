<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Boutube에 오신것을 환영합니다.</title>
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
			<jsp:include page="/Leftside.jsp"/>
			<div class="col-sm-8 text-left">
				<jsp:include page="ContentsList.jsp"/>
			</div>
				<div class="col-sm-8 text-left">
				<h1>Welcome</h1>
				<c:forEach var="content" items="${contents}">
				<div class="col-sm-5">
    			<video width="280" height="200" >
 						<source src="../video/${content.video}" type="video/mp4">
					</video>
      		<p>Some text..</p>
    		</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<jsp:include page="/Copyright.jsp" />
	</footer>

</body>
</html>
