<%-- EL을 이용하여 게시물 데이터 출력하기 --%>
<%@page import="java76.pms.domain.Plans"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
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
<jsp:include page="/Header.jsp"/>
	<div class="jumbotron">
		<div class="container text-center">
			<h1>My Portfolio</h1>
			<p>Some text that represents "Me"...</p>
		</div>
	</div>

	<div class="container-fluid bg-3 text-center">
		<h3>Some of my Work</h3>
		<br>
		<div class="row">

			<c:forEach var="plan" items="${plans}">
				<!--  <img src='../file/s-${(empty student.pic)?"default":student.pic}.png'> -->
				<div class="col-sm-3">
					<p>${plan.plan_title}
					<a href='detail.do?no=${plan.no}'><img src="../attachFile/image.jpeg" width="150" height="80"
						class="img-responsive" style="width: 100%" alt="Image"></a>
					</p>
				</div>
			</c:forEach>

		</div>
	</div>
	<br>

	<footer class="container-fluid text-center">
		<jsp:include page="/Copyright.jsp" />
	</footer>

</body>
</html>
