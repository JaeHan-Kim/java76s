package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.ContextLoader;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;

public class StudentAddServlet extends GenericServlet{
  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException { 
    StudentDao studentDao = ContextLoader.context.getBean(StudentDao.class);
    Student student = new Student();

    student.setName(request.getParameter("name"));

    student.setEmail(request.getParameter("email"));

    student.setTel(request.getParameter("tel"));

    student.setCid(request.getParameter("cid"));

    studentDao.insert(student);
    PrintWriter out = (PrintWriter)response.getWriter();
    out.println("저장되었습니다.");
  }
}
