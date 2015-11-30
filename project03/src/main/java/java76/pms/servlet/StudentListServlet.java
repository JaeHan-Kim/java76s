package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Project;
import java76.pms.domain.Student;
public class StudentListServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException { 
    try{
      int pageNo = 1;
      int pageSize = 10;
      if (request.getParameter("pageNo") != null) {
        pageNo =Integer.parseInt(request.getParameter("pageNo"));
      }
      if (request.getParameter("pageSize") != null) {
        pageSize =Integer.parseInt(request.getParameter("pageSize"));
      }

      // 정렬 처리
      String keyword = "name";
      String align = "asc";
      if (request.getParameter("keyword") != null) {
        keyword = request.getParameter("keyword");
      }
      if (request.getParameter("align") != null) {
        align = request.getParameter("align");
      }

      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
          .getAttribute("iocContainer");
      StudentDao studentDao = iocContext.getBean(StudentDao.class);

      List<Student> students = studentDao.selectList(pageNo, pageSize, keyword, align);
 
      request.setAttribute("students", students);
      response.setContentType("text/html;charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher("/student/StudentList.jsp");
      rd.include(request, response);
    
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}
