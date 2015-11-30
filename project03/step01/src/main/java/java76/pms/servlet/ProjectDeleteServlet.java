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
import java76.pms.dao.ProjectDao;

public class ProjectDeleteServlet extends GenericServlet{
  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    ProjectDao projectDao = ContextLoader.context.getBean(ProjectDao.class);
   
    int no = Integer.parseInt(request.getParameter("no"));

    PrintWriter out = (PrintWriter)response.getWriter();

    if (projectDao.delete(no) > 0){
      out.println("삭제하였습니다.");
    } else {
      out.println("해당 번호의 프로젝트가 존재하지 않습니다.");
    }


  } 
}
