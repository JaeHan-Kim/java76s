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
import java76.pms.domain.Student;

public class StudentUpdateServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException { 
    try {
      
      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
                                  .getAttribute("iocContainer");
      StudentDao studentDao = iocContext.getBean(StudentDao.class);
      Student student = new Student();

      student.setName((String)request.getParameter("name"));
      student.setEmail((String)request.getParameter("email"));
      student.setTel((String)request.getParameter("tel"));
      student.setCid((String)request.getParameter("cid"));

      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      if (studentDao.update(student) > 0){
        out.println("저장되었습니다. 1초 후에 List로 이동 합니다.");
        RequestDispatcher rd = request.getRequestDispatcher("/copyright");
        rd.include(request, response);
        response.setHeader("Refresh","1;url=list");
      }
      else
        out.println("유효하지않습니다.");
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }
}
