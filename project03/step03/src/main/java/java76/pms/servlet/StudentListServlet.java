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

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
          .getAttribute("iocContainer");
      StudentDao studentDao = iocContext.getBean(StudentDao.class);
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>학생-목록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>학생 목록</h1>");
      
      out.println("<a href='form.html'>새 글</a><br>");
      
      out.println("<table border='1'>");
      out.println("<tr>");
      out.println("  <th>Email</th>");
      out.println("  <th>Name</th>");
      out.println("  <th>Tel</th>");
      out.println("  <th>Cid</th>");
      out.println("</tr>");
      
      for (Student student : studentDao.selectList(pageNo, pageSize, keyword, align)) {
        out.println(" <tr>");
        out.printf("   <td>%s</td> \n", student.getEmail());
        out.printf("   <td><a href='update?email=%s'>%s</a></td> \n", 
            student.getEmail(),student.getName());
        out.printf("   <td>%s</td> \n", student.getTel());
        out.printf("   <td>%s</td> \n", student.getCid());
        out.println(" </tr>");
      }
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");
      rd.include(request, response);
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }

}
