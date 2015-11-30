<%-- EL을 이용하여 게시물 데이터 출력하기 --%>
<%@page import="java76.pms.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
		contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시판-목록</title>
</head>
<body>
<h1>게시판(With JSP + EL + JSTL)</h1>
<a href='http://search.naver.com/search.naver?where=nexearch&query=
%EC%84%A4%ED%98%84&sm=top_lve&ie=utf8'>새 글</a><br>
<%-- <a href='form.html'>새 글</a><br>--%>
<table border='1'>
<tr>
  <th>번호</th>
  <th>제목</th>
  <th>조회수</th>
  <th>등록일</th>
</tr>
  <c:forEach var="board" items="${boards}">
 <tr>
   <td>${board.no}</td> 
   <td><a href='update?no=${board.no}'>${board.title}</a></td> 
   <td>${board.views}</td> 
   <td>${board.createdDate}</td> 
 </tr>
 </c:forEach>
</table>
	<jsp:include page="/Copyright.jsp"/>
</body>
</html>
    