<%@ page language="java" 
		contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<meta http-equiv="REfresh" content="2;url=list">
<title>프로젝트 - 오류</title>
</head>
<body>
<h1> 오류 !</h1>
<p>
<c:choose>
<c:when test="${errorCode == '401'}">
	해당 회원이 존재하지 않거나 잘못된 이메일 입니다.
</c:when>
<c:otherwise>
	알 수 없는 오류로 실행하지 못했습니다.
</c:otherwise>
</c:choose>
</p>
<jsp:include page="/Copyright.jsp"/>
</body>
</html>
