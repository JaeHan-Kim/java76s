/* ServletRequest에 저장된 데이터 사용하기
 
*/
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherServlet extends javax.servlet.http.HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("오류가 발생했습니다.");
    Exception e = (Exception)request.getAttribute("error");
    
    StringWriter stringBuffer = new  StringWriter();
    PrintWriter tempOutput = new PrintWriter(stringBuffer);
    e.printStackTrace(tempOutput);
    
    out.println(stringBuffer.toString());
  }
}
