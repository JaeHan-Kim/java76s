<%-- 클래스 임포트 하기
	. <%@ page import="패키지정보"%>
	. 기존의 page 태그에 붙여도 되고, 새로 page 태그를 선언해도 된다.
	. 콤마(,)를 사용하여 여러 개의 패키지를 임포트할 수 있다.
	. 단 한 page 내에 여러개의 import 속성이 올수 없다.
--%>

<%-- 
기존의 page 지시어에 붙여도 된다. 
--%>
<%@ page language="java" 
	contentType="text/plains; charset=UTF-8"
	pageEncoding="UTF-8"
  import="java.util.ArrayList"
  import="java.io.File"
   import="java.net.Socket"
%>

<% 
ArrayList list2 = null;
File f = null;
Socket s = null;
%>



