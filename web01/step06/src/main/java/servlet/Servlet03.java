/* forward
 
*/
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet03 extends javax.servlet.http.HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("GET : Servlet03 출력...");

    // 다른 서블릿으로 실행을 위임하기
    // 1) 다른 서블릿으로 요청을 배달할 책임자를 얻는다.
    RequestDispatcher rd =
        request.getRequestDispatcher("/step06/otherservlet");
    // 2) 다른 서블릿으로 실행을 위임한다.
    //  - 자신이 받은 요청 객체와 응답 객체를 다른 서블릿에게 넘긴다.
    rd.forward(request, response);
  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("Post : Servlet03 출력...");

    // 다른 서블릿으로 실행을 위임하기
    // 1) 다른 서블릿으로 요청을 배달할 책임자를 얻는다.
    RequestDispatcher rd =
        request.getRequestDispatcher("/step06/otherservlet");
    // 2) 다른 서블릿으로 실행을 위임한다.
    //  - 자신이 받은 요청 객체와 응답 객체를 다른 서블릿에게 넘긴다.
    rd.forward(request, response);
  }
}