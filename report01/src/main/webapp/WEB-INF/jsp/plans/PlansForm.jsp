<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>new Todo List</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="../css/button.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/Header.jsp"/>
	<form action='add.do' method='post' role="form" enctype="multipart/form-data">
      <div class="container">
         <p>중요한 일을 잊지 않게 추가해 보세요.</p>
      <div class="form-group has-warning">
        <label for="usr">계획 :</label>
        <input type="text" class="form-control">
      </div>
      <div class="form-group has-success">
        <label for="pwd">상세계획 :</label>
        <textarea class="form-control" rows="5" name='plan_content'
						placeholder="상세계획을 입력하세요."></textarea>
      </div>
      <div class="form-group has-error">
        <label for="d_day">D-Day :</label>
        <input type="date" class="form-control">
      </div>
      <div class="form-group has-primary">
        <label for="file">첨부파일 :</label>
        <input type="file" class="form-control">
      </div>
      <p>
		<button type='submit' class="button button3">등록</button>
	  </p>
	 
  </form>
</div>
	<footer class="container-fluid text-center">
		<jsp:include page="/Copyright.jsp" />
	</footer>
</body>
</html>
