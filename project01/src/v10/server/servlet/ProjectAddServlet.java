package v10.server.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;

import v10.server.dao.ProjectDao;
import v10.server.domain.Project;



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
