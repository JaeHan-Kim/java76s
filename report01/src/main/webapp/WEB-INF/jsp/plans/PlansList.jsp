<%-- EL을 이용하여 게시물 데이터 출력하기 --%>
<%@page import="java76.pms.domain.Plans"%>
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

<jsp:include page="/Header.jsp"/>
<h1>게시판(With JSP + EL + JSTL)</h1>
<a href='add.do'>새 글</a><br>
<%-- <a href='form.html'>새 글</a><br>--%>
<table border='1'>
<tr>
  <th>계획 </th>
  <th>D-?</th>
  <th>D-day</th>
</tr>
  <c:forEach var="plan" items="${plans}">
 <tr>
   <td>${plan.no}</td> 
   <td><a href='detail.do?no=${plan.no}'>${plan.plan_title}</a></td> 
   <td>${plan.d_day}</td> 
 </tr>
 </c:forEach>
</table>
	<jsp:include page="/Copyright.jsp"/>
</body>
</html>
    