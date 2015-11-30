package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 웹 브라우저가 쿠키를 보내는 조건 */

@WebServlet("/otherpath/servlet04")
public class Servlet04 extends HttpServlet{
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

