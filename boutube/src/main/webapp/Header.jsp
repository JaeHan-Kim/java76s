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
			<a href="../contents/main.do"><img src="../img/boutube.png"
				style="vertical-align: middle"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li>  </li>
				<li>
					<c:if test="${not empty loginUser && loginUser.uno == 1}">
					<a href="${pageContext.request.contextPath}/users/detail.do"> 
					${loginUser.name}님
					</a>
					</c:if> 
					<c:if test="${not empty loginUser && loginUser.uno != 1}">
					<a href="#"> 
					${loginUser.name}님
					</a>
					</c:if>
				</li>
				<li><a href="add.do">Upload</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
				<c:if test="${not empty loginUser}">
					<a href="${pageContext.request.contextPath}/auth/logout.do"> <span
							class="glyphicon glyphicon-log-out"></span>Logout
					</a>
					</c:if> 
					<c:if test="${empty loginUser}">
						<a href="#"> <span class="glyphicon glyphicon-log-in"
						data-toggle="modal" data-target="#squarespaceModal"> Login</span>
				</a> 
					</c:if></li>

				<div class="modal fade" id="squarespaceModal" tabindex="-1"
					role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span><span class="sr-only">Close</span>
								</button>
								<h3 class="modal-title" id="lineModalLabel">로그인</h3>
							</div>
							<div class="modal-body">

								<!-- content goes here -->
								<form action="${pageContext.request.contextPath}/auth/login.do" method="post">
									<div class="form-group">
										<label for="exampleInputEmail1">Email address</label> <input
											type="email" class="form-control" name="email"
											value"" placeholder="Enter email">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Password</label> <input
											type="password" class="form-control" name="password"
											placeholder="Password">

									</div>
									<div class="checkbox">
										<label> <input type="checkbox"> email 저장
										</label>
									</div>
									<div class="btn-group btn-group-justified" role="group"
										aria-label="group button">
										<div class="btn-group" role="group">
											<button type="submit" id="saveImage"
												class="btn btn-default btn-hover-green" data-action="save"
												role="button">Login</button>
										</div>
										<div class="btn-group btn-delete hidden" role="group">
											<button type="button" id="delImage"
												class="btn btn-default btn-hover-red" data-dismiss="modal"
												role="button">Delete</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												data-dismiss="modal" role="button">cancle</button>
										</div>
									</div>
								</form>

							</div>
						</div>
					</div>
				</div>
				
				<li><a href="#"><span class="glyphicon glyphicon-log-in"
				data-toggle="modal" data-target="#joinModal"> Join Us</span>
						</a></li>
			
			<div class="modal fade" id="joinModal" tabindex="-1"
					role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span><span class="sr-only">Close</span>
								</button>
								<h3 class="modal-title" id="lineModalLabel">회원가입</h3>
							</div>
							<div class="modal-body">

								<!-- content goes here -->
								<form action="${pageContext.request.contextPath}/users/add.do" method="post" 
								enctype="multipart/form-data">
									<div class="form-group">
										<label for="exampleInputEmail1">Email address</label> <input
											type="email" class="form-control" name="email"
											value"" placeholder="Enter email">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Name</label> <input
											type="text" class="form-control" name="name"
											value"" placeholder="Enter email">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Nick name</label> <input
											type="text" class="form-control" name="nickname"
											value"" placeholder="Enter email">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Create Password</label> <input
											type="password" class="form-control" name="password"
											placeholder="Password">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Confirm your Password</label> <input
											type="password" class="form-control" name="rePassword"
											placeholder="Password">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Photo</label> <input
											type="file" class="form-control" name="photofile"
											value"" placeholder="Enter email">
									</div>									
									<div class="btn-group btn-group-justified" role="group"
										aria-label="group button">
										<div class="btn-group" role="group">
											<button type="submit" id="saveImage"
												class="btn btn-default btn-hover-green" data-action="save"
												role="button">Join</button>
										</div>
										<div class="btn-group btn-delete hidden" role="group">
											<button type="button" id="delImage"
												class="btn btn-default btn-hover-red" data-dismiss="modal"
												role="button">Delete</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												data-dismiss="modal" role="button">cancle</button>
										</div>
									</div>
								</form>

							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
</nav>
</ul>
