<%-- 게시물 변경, 삭제할 때 권한이 없는 경우  --%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <meta http-equiv="Refresh" content="2;url=../contents/main.do">
  <title>회원 가입-오류</title>
</head>
<body>
<h1>실행 오류!</h1>

<p>
<c:choose>
<c:when test="${errorCode == '401'}">
비밀번호 오류입니다. 갱신 할 수 없습니다.
</c:when>
<c:when test="${errorCode == '500'}">
중복된 이메일입니다. 사용할 수 없습니다!
</c:when>
<c:when test="${errorCode == 'regex'}">
올바른 이메일 주소를 입력해주세요!
</c:when>
<c:when test="${errorCode == 'pwd'}">
패스워드가 일치하지 않습니다!
</c:when>
<c:otherwise>
알 수 없는 오류로 실행하지 못했습니다.
</c:otherwise>
</c:choose>
</p>

<jsp:include page="/Copyright.jsp"/>

</body>
</html>