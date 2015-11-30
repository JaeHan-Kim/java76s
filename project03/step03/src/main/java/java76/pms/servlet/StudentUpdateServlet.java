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
    String email = request.getParameter("email");
    ApplicationContext iocContext = 
        (ApplicationContext)this.getServletContext()
        .getAttribute("iocContainer");

    StudentDao studentDao = iocContext.getBean(StudentDao.class);
    Student student = studentDao.selectOne(email);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시판 - 상세정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 정보</h1>");

    out.println("<form id='form1' action = 'update' method='post'>");
    out.println("<table border='1'>");
    out.println(" <tr>");
    out.println("   <th>cid</th>");
    out.printf("   <td><input type='text' value='%s' name='cid'></td>", 
        student.getCid());
    out.println(" </tr>");
    out.println(" <tr>");
    out.println("   <th>이메일</th>");
    out.printf("   <td><input type='text' value='%s' name='email' readonly></td> \n", 
        student.getEmail());
    out.println(" </tr>");
    out.println(" <tr>");
    out.println("   <th>이름</th>");
    out.printf("   <td><input type='text' name='name' value='%s'></td> \n", 
        student.getName());
    out.println(" </tr>");
    out.println(" <tr>");
    out.println("   <th>전화번호</th>");
    out.printf("   <td><input type='text' name='tel' value='%s'></td> \n", 
        student.getName());
    out.println(" </tr>");

    out.println("</table>");

    out.println("<p>");
    out.println("<button name = 'update' type ='submit'>변경</button>");
    out.printf("<button name = 'delete' type ='submit' onclick='deleteBoard()'>삭제</button>");
    out.println("</p>");

    out.println("<script>");
    out.println("function deleteBoard() {");
    out.println("  document.getElementById('form1').action = 'delete';");
    out.println("}");
    out.println("</script>");

    out.println("</form>");
    out.println("</body>");
    out.println("</html>");

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

      student.setName((String)request.getParameter("name"));
      student.setEmail((String)request.getParameter("email"));
      student.setTel((String)request.getParameter("tel"));
      student.setCid((String)request.getParameter("cid"));

      if (studentDao.update(student) > 0){
        response.sendRedirect("list");
        return;
      }

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>학생정보 - 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>학생정보 변경 오류</h1>");
      out.println("<p>유효하지않습니다.</p>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");
      rd.include(request, response);
     
      out.println("</body>");
      out.println("</html>");

      response.setHeader("Refresh","2;url=list");
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }
}
