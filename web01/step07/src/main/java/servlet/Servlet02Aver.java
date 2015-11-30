/* ServletRequest를 사용하여 including 하는 동안 데이터 공유하기
 => 클라이언트가 보낸 데이터를 가지고 합계(Servlet02Sum)와 평균(Servlet02Aver)을 구한 다음,
    그 결과를 ServletRequest에 보관한다.
 
 
*/
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02Aver extends javax.servlet.http.HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    int sum = (int)request.getAttribute("sum");
    float aver = sum / 3f;

    request.setAttribute("aver", aver);
  }
}
