package v11.server.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import v11.server.annotation.Component;
import v11.server.dao.ProjectDao;
import v11.server.domain.Project;

@Component("/project/list")
public class ProjectListServlet implements Servlet{
  ProjectDao projectdao = null;

  public void setProjectDao(ProjectDao projectdao) {
    this.projectdao = projectdao;
  }

  @Override
  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");

    out.printf("%-3s %-20s %-10s %-10s %-40s\n", 
        "No", "Title", "Start", "End", "Members");

    int i = 0;
    for (Project project : projectdao.selectList()) {
      if (project == null) 
        continue;
      out.printf("% 3d %-20s %3$tY-%3$tm-%3$td %4$s %5$-40s\n", 
          i++, 
          project.getTitle(),
          project.getStartDate(),
          project.getEndDate(),
          project.getMember());
    }
   /* 
    try {
      Thread.currentThread().sleep(10000);
    } catch (InterruptedException e) {}*/
  }
}
