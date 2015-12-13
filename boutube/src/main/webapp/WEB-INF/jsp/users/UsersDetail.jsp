
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
</style>
</head>
<body>
	<jsp:include page="/Header.jsp" />
	
	<div class="container-fluid text-center">
		<div class="row content">
			<jsp:include page="/Leftside.jsp"/>
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
					<th>비밀번</th>
					<td><input type='password' name='password'></td>
				</tr>
			</table>

			<p>
				<button name="update" type="submit" class='button1'>변경</button>
				<a id='aDelete' href='delete.do?pno=${users.uno}' class='button2' onclick='deleteBoard()'>삭제</a>
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
</body>
</html>