package v05.command;

import java.util.ArrayList;
import java.util.HashMap;

import v05.Project;
import v05.Student;

public class StudentListCommand implements Command{
  public void execute(HashMap<String, Object> params) { 
    
    Student student = null;
    ArrayList<Student> list = (ArrayList<Student>)params.get("list");
    
    for (int i = 0; i < list.size(); i++) {
      student = list.get(i);
      if (student == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      System.out.printf("%d %s %s %s %s\n", 
          i, 
          student.getName(),
          student.getEmail(),
          student.getTel(),
          student.getCid());
    }
  }
}
