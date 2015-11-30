package java76.pms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;

@Component("/project/add")
public class ProjectAddServlet implements Servlet {
  ProjectDao projectdao = null;
  public void setProjectDao(ProjectDao projectdao) {
    this.projectdao = projectdao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    Project project = new Project();
    project.setTitle((String)params.get("title"));
    
    project.setStartDate(Date.valueOf((String)params.get("startDate")));
    
    project.setEndDate(Date.valueOf((String)params.get("endDate")));

    project.setMember((String)params.get("member"));
    
      projectdao.insert(project); 
      
      PrintStream out = (PrintStream)params.get("out");
      out.println("저장되었습니다.");
      
  }
}
