package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.StudentDao;
public class StudentDeleteServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException { 
    try {
      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
                                  .getAttribute("iocContainer");
      StudentDao studentDao = iocContext.getBean(StudentDao.class);
      String email = request.getParameter("email");

      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();

      if (studentDao.delete(email) > 0) { 
        response.sendRedirect("list");
      } else {
        out.println("해당 학생이 존재하지 않습니다.");
      }
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }

}
