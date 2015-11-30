/* 파라미터 값을 꺼낸다
 
 
*/
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02Sum extends javax.servlet.http.HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

      int kor = Integer.parseInt(request.getParameter("kor"));
      int math = Integer.parseInt(request.getParameter("math"));
      int hist = Integer.parseInt(request.getParameter("hist"));
      
      int sum = kor + math + hist;

      request.setAttribute("sum", sum);
  }
}
