package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;

public class ProjectAddServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
                                  .getAttribute("iocContainer");
      ProjectDao projectDao = iocContext.getBean(ProjectDao.class);
      Project project = new Project();
      project.setTitle(request.getParameter("title"));

      project.setStartDate(Date.valueOf(request.getParameter("startDate")));

      project.setEndDate(Date.valueOf(request.getParameter("endDate")));

      project.setMember(request.getParameter("member"));

      projectDao.insert(project); 

      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("저장되었습니다. 1초 후에 List로 이동 합니다.");
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");
      rd.include(request, response);
      response.setHeader("Refresh","1;url=list");
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }
}
