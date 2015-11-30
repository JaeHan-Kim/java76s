/* HttpSession에 timeout 설정하기

 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet05Logout extends javax.servlet.http.HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");

    HttpSession session = request.getSession();

    // 세션을 강제로 무효화 시킨다.
    session.invalidate(); 

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("로그 아웃 하였습니다..(세션을 무효화시켰습니다.)");
  }
}
