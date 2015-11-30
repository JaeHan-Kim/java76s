/* Redirect
 
*/
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02 extends javax.servlet.http.HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("결과를 출력한다.");
    out.println("그리고 3초 후에 Daum.net 사이트를 요청하게 만든다.");
    // out.println();
    /* sendRedirect()를 호출하면,
     * 버퍼에 출력된 내용을 버린다. => semdRedorect()를 사용한다면 중간에 쓸데없이
     *                            출력하지 말아라!
     * 클라이이언트에는 다른 자원의 URL을 응답헤더(Location)에 실어서 보낸다.
     * sendRedirect() 호출 전에 flush()를 호출한다면, redirect능 무시된다.
     */
    response.sendRedirect("http://www.daum.net");
  }
}
