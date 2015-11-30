package v11.server.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import v11.server.annotation.Component;
import v11.server.dao.StudentDao;
import v11.server.domain.Student;
@Component("/student/list")
public class StudentListServlet implements Servlet{
 
  StudentDao studentDao = null;

  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    
    int i = 0;
    for (Student student : studentDao.selectList()) {
      if (student == null) 
        continue;
      out.printf("%d %s %s %s %s\n", 
          i++, 
          student.getName(),
          student.getEmail(),
          student.getTel(),
          student.getCid());
    }
  }

}
