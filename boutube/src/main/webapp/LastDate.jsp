<%@page import="java.time.Year"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" 
	import="java.text.DateFormat, java.util.Calendar, java.sql.Date" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    // 마지막 방문일을 저장하고 있는 쿠키를 저장할 객체
    Cookie lastDate = null;

	// 화면에 출력할 메시지를 저장할 문자열 변수
    String msg = "";
    
    // 마지막 방문일을 저장하고 있는 쿠키가 존재하는지를 판별할 변수
    boolean found = false;
    
    // 현재 시간을 저장
    String newValue = "" + System.currentTimeMillis();
    
    // 쿠키를 얻는다.
    Cookie[] cookies = request.getCookies();
    
    // 마지막 방문 일을 정하고 있는 쿠키를 검색
    if (cookies != null) {
        
        for (int i = 0; i < cookies.length; i++) {
            
            lastDate = cookies[i];
            
            if (lastDate.getName().equals("lastdateCookie")) {
                
                found = true;
                break;
            }
        }
    }
    
    // 처음 방문일 경우 새 쿠키 생성
    if (!found) {    // if (found = false)
        
        msg = "처음 방문하셨습니다. 일정을 등록하세요.";
    
        // 쿠키 객체를 생성
        lastDate = new Cookie("lastdateCookie", newValue);
        
        // 쿠키 속성값을 설정
        lastDate.setMaxAge(365*24*60*60);    // 365일
        lastDate.setPath("/");
        
        // 쿠키를 추가
        response.addCookie(lastDate);
    }
    
    else {    // 이미 방문한 적이 있는 클라이언트라면
        
        // 이전 방문시간을 알아내어 long형 변수 conv에 저장
        long conv = new Long(lastDate.getValue()).longValue();
    
        // 방문시간을 출력할 수 있도록 msg 변수에 저장
        Date date = new Date(System.currentTimeMillis());
        String year = date.getTime() + 1900 + "년";
        msg = "당신의 마지막 방문 : " + year;
        
        // 쿠키에 새 값을 추가
        lastDate.setValue(newValue);
        
        // 쿠키를 추가
        response.addCookie(lastDate);
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마지막 방문 일을 출력하는 웹 페이지를 쿠키를 이용하여 작성하기</title>
</head>
<body>
<h2><%= msg %></h2>
</body>
</html>