
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>회원 정보 수정</title>
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
/*-------------------------------------------------*/
.row {
	margin-left: 0px;
	margin-right: 0px;
}

#wrapper {
	padding-left: 70px;
	transition: all .4s ease 0s;
	height: 100%
}

#sidebar-wrapper {
	margin-left: -150px;
	left: 70px;
	width: 150px;
	background: #222;
	position: fixed;
	height: 100%;
	z-index: 10000;
	transition: all .4s ease 0s;
}

.sidebar-nav {
	display: block;
	float: left;
	width: 150px;
	list-style: none;
	margin: 0;
	padding: 0;
}

#page-content-wrapper {
	padding-left: 0;
	margin-left: 0;
	width: 100%;
	height: auto;
}

#wrapper.active {
	padding-left: 150px;
}

#wrapper.active #sidebar-wrapper {
	left: 150px;
}

#page-content-wrapper {
	width: 100%;
}

#sidebar_menu li a, .sidebar-nav li a {
	color: #999;
	display: block;
	float: left;
	text-decoration: none;
	width: 150px;
	background: #252525;
	border-top: 1px solid #373737;
	border-bottom: 1px solid #1A1A1A;
	-webkit-transition: background .5s;
	-moz-transition: background .5s;
	-o-transition: background .5s;
	-ms-transition: background .5s;
	transition: background .5s;
}

.sidebar_name {
	padding-top: 25px;
	color: #fff;
	opacity: .7;
}

.sidebar-nav li {
	line-height: 40px;
	text-indent: 20px;
}

.sidebar-nav li a {
	color: #999999;
	display: block;
	text-decoration: none;
}

.sidebar-nav li a:hover {
	color: #fff;
	background: rgba(255, 255, 255, 0.2);
	text-decoration: none;
}

.sidebar-nav li a:active, .sidebar-nav li a:focus {
	text-decoration: none;
}

.sidebar-nav>.sidebar-brand {
	height: 65px;
	line-height: 60px;
	font-size: 18px;
}

.sidebar-nav>.sidebar-brand a {
	color: #999999;
}

.sidebar-nav>.sidebar-brand a:hover {
	color: #fff;
	background: none;
}

#main_icon {
	float: right;
	padding-right: 35px;
	padding-top: 20px;
}

.sub_icon {
	float: right;
	padding-right: 65px;
	padding-top: 10px;
}

.content-header {
	height: 65px;
	line-height: 65px;
}

.content-header h1 {
	margin: 0;
	margin-left: 20px;
	line-height: 65px;
	display: inline-block;
}

@media ( max-width :767px) {
	#wrapper {
		padding-left: 70px;
		transition: all .4s ease 0s;
	}
	#sidebar-wrapper {
		left: 70px;
	}
	#wrapper.active {
		padding-left: 150px;
	}
	#wrapper.active #sidebar-wrapper {
		left: 150px;
		width: 150px;
		transition: all .4s ease 0s;
	}
}
</style>
</head>
<body>
	<jsp:include page="/Header.jsp" />
	<!-- ----------------------------------- -->
	<div class="container-fluid text-center">
		<div class="row content">
			<div id="wrapper" class="active">

		<div id="sidebar-wrapper">
					<ul id="sidebar_menu" class="sidebar-nav">
						<li class="sidebar-brand"><a id="menu-toggle" href="#">Menu<span
								id="main_icon" class="glyphicon glyphicon-align-justify"></span></a></li>
						<ul class="sidebar-nav" id="sidebar">
						</ul>
					</ul>
				</div>
	
	<div class="container-fluid text-center">
		<div class="row content">
				<div class="col-sm-8 text-left">
<h1>개인 정보 수정</h1>
	<c:if test="${not empty users}">
		<form id='form1' action='update.do' method='post' enctype="multipart/form-data">
			<table border='1'>
				<tr>
				<th>Picture</th>
					<td><img width='200' height='300' 
      			src='../photo/${(empty users.photo)?"default.png":users.photo}' width="300" height="300"><br>
   		    <input type='file' name='photofile'>
      		<input type='hidden' name='photo' value='${users.photo}'></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
					<input type='text' value='${users.email}' name='email' readonly>
					<input type='hidden' name='uno' value='${users.uno}'>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type='text' value='${users.name}' name='name'></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type='password' name='password'></td>
				</tr>
			</table>

			<p>
			<br>
				<button name="update" type="submit" class="btn btn-info" class="btn btn-primary btn-md">변경</button>
				<a id='aDelete' href='delete.do?uno=${users.uno}' onclick='deleteBoard()'class="btn btn-info" class="btn btn-primary btn-md" role="button">삭제</a>
			</p>
		</form>
		<script>
			function deleteBoard() {
				// 암호 텍스트 상자에 입력된 내용을 가져온다.
				var password = document.getElementById('inputPassword').value;

				// a 태그의 href 값을 가져와서 "&password=암호" 문자열을 붙인다.
				var href = document.getElementById('aDelete').href
						+ "&password=" + password;

				// a 태그의 href 값을 암호 파라미터가 붙은 값으로 변경한다. 
				document.getElementById('aDelete').href = href;
			}
		</script>
	</c:if>
	<c:if test="${empty users}">
		<p>해당 유저는 존재하지 않습니다.</p>
	</c:if>
			</div>
		</div>
	</div>

<footer class="container-fluid text-center">
	<jsp:include page="/Copyright.jsp" />
</footer>
</div>
</div>
</div>
<script>
$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("active");
});
</script>
</body>
</html>