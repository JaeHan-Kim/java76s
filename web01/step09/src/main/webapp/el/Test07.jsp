<%-- EL 사용법 (Expression Language)
--%>
<%@ page language="java" 
	contentType="text/plains; charset=UTF-8"
	pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%-- EL에서 재공하는 기본 객체
	pageContext 		: PageContext				
	servletContext 	: ServletContext		=> ${pageContext.servletContext.객체명}
	session					: HttpSession				=> ${pageContext.session.객체명}
	request					: ServletRequest		=> ${pageContext.request.객체명}
	response				: ServletResponse		
	param						: ${param.파라미터명}
	paramValues			: ${paramValues.파라미터명}
	header					: ${header.헤더명}
	headerValues		: ${headerValues.헤더명}
	cookie					: ${cookie.쿠키명}
	initParam				: ${initParam.컨텍스트 초기화 파라미터명}
	pageScope
	requestScope
	sessionScope
	applicationScope
--%>
----------------------------------
<%-- 파라미터 값 꺼내기 
=> 파라미터 값이 없으면 null이 아닌 빈문자를 출력 
=> 예) http://localhost:8080/web01/el/Test07.jsp?name=aaa&age=10
--%>
name 파라미터 값 : ${param.name} 
age 파라미터 값 : ${param.age} 
----------------------------------
<%-- 헤더 값 꺼내기 
	=> 헤더 이름에 대해 대소문자를 구분하지 않는다.
--%>
User-Agent 헤더 값 : ${header["User-Agent"]}
User-Agent 헤더 값 : ${header["user-agent"]}