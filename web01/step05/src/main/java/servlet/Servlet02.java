/* HttpServletRequset 도구 사용
 => ServletRequest 도구는 단순한 요청 정보를 다룬다면,
 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    // 1) 공공연한 비밀
    // 서블릿 컨테이너가 service()를 호출할 때 넘겨주는 값은 실제
    // HttpServletRequest와 HttpServletResponse 이다.
    // 그래서 이 타입으로 타입 캐스팅 할 수 있다.
    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpServletResponse httpResp = (HttpServletResponse) response;
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.printf("클라이언트 IP : %s \n", request.getRemoteAddr());
    out.printf("클라이언트 이름 : %s \n", request.getRemoteHost());
    out.printf("클라이언트 포트 : %s \n", request.getRemotePort());
    out.printf("프로토콜 이름 : %s \n", request.getScheme());
  
    out.println("HttpServletRequest를 통해 뽑아내는 정보");
    out.printf("getContextPath() : %s \n", httpReq.getContextPath());
    out.printf("getMethod() : %s \n", httpReq.getMethod());
    out.printf("getPathInfo() : %s \n", httpReq.getPathInfo());
    out.printf("getQueryString() : %s \n", httpReq.getQueryString());
    out.printf("getRequestURI() : %s \n", httpReq.getRequestURI());
    out.printf("getRequestURL() : %s \n", httpReq.getRequestURL());
    out.printf("getServletPath() : %s \n", httpReq.getServletPath());
    out.printf("getHeader(User-Agent) : %s \n", 
        httpReq.getHeader("User-Agent"));
    
  }
}
