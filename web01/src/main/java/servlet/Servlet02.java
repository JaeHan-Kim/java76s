package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 클라이언트가 보낸 쿠키 정보 꺼내기 */

@WebServlet("/step10/servlet02")
public class Servlet02 extends HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // 1) 요청 객체에서 쿠키 목록을 꺼낸다.
    // => 요청 헤더 "Cookie"의 값을 세미클론(;)으로 구분하고,
    //    Cookie 객체의 배열로 만들어 리턴한다.
    // => 단, 이 서블릿을 실행하기 전에 먼저 서버 쪽에서 쿠키를 보내야한다.
    // => 웹 브라우저는 단지 서버가 맡긴 쿠키를 보낼 뿐이다.
    Cookie[] cookies = request.getCookies();
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    // 2) 만약 요청 헤더에 쿠키 정보 있다면 출력한다.
    if (cookies == null) {
      out.println("웹 브라우저가 보낸 쿠키가 한 개도 없습니다!");
      return;
    }
    
    for (Cookie cookie : cookies) {
      out.printf("%s = %s \n ", cookie.getName(), cookie.getValue());
    }
  }
}

