package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.BoardDao;

public class BoardDeleteServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException { 
    try{
      int no = Integer.parseInt(request.getParameter("no"));

      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
                                  .getAttribute("iocContainer");
      BoardDao boardDao = iocContext.getBean(BoardDao.class);

      if (boardDao.delete(no)>0) {
        response.sendRedirect("list");
      } else {
        out.println("해당 번호의 프로젝트가 존재하지 않습니다.");
      }
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }
}
