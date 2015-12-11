<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Todo List 회원가입 페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
  <h1>Hello Todo List 회원 가입하기</h1>
  <p>일정을 등록하고 기억하면, 일상이 더욱 효율적으로 됩니다</p>      
  <div class="row">
    <div class="col-sm-6" style="background-color:lavender;">
      <p>간편한 가입만으로 일정을 손쉽게 관리 할 수 있습니다.</p>
      <p>오늘 해야 할 일을 체크하고, 당신의 계획이 몇 일 남았는지 쉽게 체크 할 수 있습니다.</p>
    </div>
    <div class="col-sm-6" style="background-color:lavenderblush;">
      <p>일정을 페이스북, 카카오톡, 라인, 이메일 등 다양한 서비스로 보낼 수 있습니다(향후 지원 예정).</p>
    </div>
  </div>
</div>

<div class="container">
  <form role="form" action="add.do" enctype="multipart/form-data" method="post">
    <div class="form-group">
      <label for="inputdefault">이름 :</label>
      <input class="form-control" id="inputdefault" type="text" name="name" placeholder="이름을 입력하세요.">
    </div>
    <div class="form-group">
      <label for="inputdefault">Email :</label>
      <input class="form-control" id="inputdefault" type="text" name="email" placeholder="Example@TodoList.com">
    </div>
    <div class="form-group">
      <label for="inputdefault">Password :</label>
      <input class="form-control" id="inputdefault" type="password" name="password" placeholder="영어 숫자 혼합 6자리 이상입니다.">
    </div>
   <!--  <div class="form-group">
      <label for="inputdefault">Password 확인 :</label>
      <input class="form-control" id="inputdefault" type="password" name="password1" placeholder="위의 비밀번호를 다시 입력하세요.">
    </div> -->
    <input type="submit" class="btn btn-danger" class="btn btn-primary btn-md" value="가입하기">
  </form>
</div>


</body> 
</html>


