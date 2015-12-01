package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/step10/servlet10")
public class Servlet10 extends HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    
    // 1) 세션을 준비한다
    // - 클라이언트가 보낸 쿠키 정보 중에서 세션ID가 있는가?
    
    HttpSession session = request.getSession();
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("세션과 쿠키");
    
  }

}
