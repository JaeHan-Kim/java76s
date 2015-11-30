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

public class StudentUpdateServlet extends GenericServlet{
  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException { 
    StudentDao studentDao = ContextLoader.context.getBean(StudentDao.class);
    Student student = new Student();

    student.setName((String)request.getParameter("name"));
    student.setEmail((String)request.getParameter("email"));
    student.setTel((String)request.getParameter("tel"));
    student.setCid((String)request.getParameter("cid"));

    PrintWriter out = (PrintWriter)response.getWriter();
    if (studentDao.update(student) > 0)
      out.println("저장되었습니다.");
    else
      out.println("유효하지않습니다.");
  }
}
