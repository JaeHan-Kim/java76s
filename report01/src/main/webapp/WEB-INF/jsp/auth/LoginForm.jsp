<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Todo List 로그인</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
   <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>

<body>

<div class="container">
  <h2>자신만의 Todo List를 관리하려면 로그인하세요.</h2>
  <p>email과 password를 입력해서 일정을 놓치지 마세요.</p>
  <form action="login.do" role="form" method="post">
    <div class="form-group">
      <label for="usr">Email:</label>
      <input type="text" name="email" class="form-control" value="${cookie.email.value}" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" name="password" class="form-control" placeholder="Enter password">
    </div>
    <button type="submit" class="btn btn-success" class="btn btn-primary btn-md">로그인</button>
    <a href="../JoinForm.jsp" class="btn btn-info" class="btn btn-primary btn-md" role="button">회원가입</a>
    <a href="help@test.com" class="btn btn-danger">
    <span class="glyphicon glyphicon-envelope"></span> Email 문의
    </a>
    <input type="checkbox" name="saveEmail" 
    ${(empty cookie.email) ? "":"checked"}>email 저장하기(개인컴퓨터 일 경우 체크하세요)<br>
  </form>
</div>

<br>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="../file/Todoist1.jpg" alt="Todo List">
      <div class="carousel-caption">
        <h3>Todo List</h3>
      </div>
    </div>

    <div class="item">
      <img src="../file/Todoist2.jpg" alt="지금 가입하세요.">
      <div class="carousel-caption">
        <h3>지금 가입하세요.</h3>
      </div>
    </div>

    <div class="item">
      <img src="../file/Todoist3.jpg" alt="효율적인 일상">
      <div class="carousel-caption">
        <h3>효율적인 일상</h3>
      </div>
    </div>

    <div class="item">
      <img src="../file/Todoist4.jpg" alt="Todo List">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

</body> 
</html>



