
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>일정 - 상세 정보</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/css1.css" />
</head>
<body>
	<jsp:include page="/Header.jsp" />
	<div class="jumbotron">
  <div class="container text-center">
	<h1>일정 - 상세 정보</h1>
	<c:if test="${not empty users}">
		<form id='form1' action='update.do' method='post' enctype="multipart/form-data">
			<table border='1'>
				<tr>
					<th>제목</th>
					<td><input type='text' value='${users.name}' name='plan_title'></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows='10' cols='60' name='content'>${users.email}</textarea></td>
				</tr>
			</table>

			<p>
				<button name="update" type="submit" class='button1'>변경</button>
				<a id='aDelete' href='delete.do?pno=${users.cno}' class='button2' onclick='deleteBoard()'>삭제</a>
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
		<p>해당 번호의 게시물을 찾을 수 없습니다.</p>
	</c:if>
  </div>
</div>
<footer class="container-fluid text-center">
	<jsp:include page="/Copyright.jsp" />
</footer>
</body>
</html>