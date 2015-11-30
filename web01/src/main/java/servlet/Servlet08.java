package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 유효기간 쿠키 확인하기 */

@WebServlet("/step10/servlet08")
public class Servlet08 extends HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    Cookie[] cookies = request.getCookies();
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    if (cookies == null) {
      out.println("웹 브라우저가 보낸 쿠키가 한 개도 없습니다!");
      return;
    }
    
    for (Cookie cookie : cookies) {
      out.printf("%s = %s \n ", cookie.getName(), cookie.getValue());
    }
  }
}
// GET /web01/otherpath/servlet06 HTTP/1.1
// Host: localhost:8080
// Connection: keep-alive
// Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
// Upgrade-Insecure-Requests: 1
// User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36
// Accept-Encoding: gzip, deflate, sdch
// Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
// Cookie: name=hong
