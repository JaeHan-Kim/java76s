<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">${loginUser.name}님</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="list.do">Home</a></li>
				<li><a href="add.do">new Todo List</a></li>
				<!-- <li><a href="#">Gallery</a></li>
				<li><a href="#">Contact</a></li> -->
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><c:if test="${not empty loginUser}">
					<a href="${pageContext.request.contextPath}/auth/logout.do">
					<span class="glyphicon glyphicon-log-out"></span>Logout</a>
				</c:if>
				<c:if test="${empty loginUser}">
					<a href="${pageContext.request.contextPath}/auth/login.do">
					<span class="glyphicon glyphicon-log-in"></span>Login</a>
				</c:if>
				</li>
			</ul>
		</div>
	</div>
</nav>

