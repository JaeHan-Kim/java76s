package v11.server.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import v11.server.annotation.Component;
import v11.server.dao.ProjectDao;

@Component("/project/delete")
public class ProjectDeleteServlet implements Servlet{
  ProjectDao projectdao = null;
  public void setProjectDao(ProjectDao projectdao) {
    this.projectdao = projectdao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    int no = Integer.parseInt((String)params.get("no"));

    PrintStream out = (PrintStream)params.get("out");
    try {
      projectdao.delete(no);
      out.println("삭제하였습니다.");
    } catch (Exception e) {
      out.println("해당 번호의 프로젝트가 존재하지 않습니다.");
    }
    

  } 
}
