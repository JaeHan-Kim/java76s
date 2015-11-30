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
      String email = request.getParameter("email");
      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
          .getAttribute("iocContainer");

      StudentDao studentDao = iocContext.getBean(StudentDao.class);
      Student student = studentDao.selectOne(email);
      
      request.setAttribute("student", student);
      
      response.setContentType("text/html;charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher("/student/StudentDetail.jsp");
      rd.include(request, response);
      
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }

  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    try {

      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
          .getAttribute("iocContainer");
      StudentDao studentDao = iocContext.getBean(StudentDao.class);
      Student student = new Student();

      student.setEmail((String)request.getParameter("email"));
      student.setName((String)request.getParameter("name"));
      student.setTel((String)request.getParameter("tel"));
      student.setCid((String)request.getParameter("cid"));

      if (studentDao.update(student) > 0){
        response.sendRedirect("list");
        return;
      }
      request.setAttribute("errorCode", "401");
      response.setContentType("text/html;charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher("/student/StudentAuthError.jsp");
      rd.include(request, response);
      
      response.setHeader("Refresh","2;url=list");
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}
