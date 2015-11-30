package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.StudentDao;
@Component("/student/delete")
public class StudentDeleteServlet implements Servlet{
  StudentDao studentDao = null;
  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    String email = (String)params.get("email");

    PrintStream out = (PrintStream)params.get("out");
    
    try {
      studentDao.delete(email);
      out.println("삭제하였습니다.");
    } catch (Exception e) {
      out.println("해당 번호의 학생이 존재하지 않습니다.");
    }
  }

}
