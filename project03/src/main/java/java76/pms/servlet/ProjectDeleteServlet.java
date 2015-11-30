package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.ProjectDao;

public class ProjectDeleteServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      
      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
                                  .getAttribute("iocContainer");
      ProjectDao projectDao = iocContext.getBean(ProjectDao.class);

      int no = Integer.parseInt(request.getParameter("no"));

      response.setContentType("text/plain;charset=UTF-8");

      if (projectDao.delete(no) > 0){
        response.sendRedirect("list");
        return;
      } 
      response.setContentType("text/plain;charset=UTF-8");
      request.setAttribute("errorCode", "401");
      RequestDispatcher rd = request.getRequestDispatcher("/project/ProjectAuthError.jsp");
      rd.include(request, response);
      
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }

  } 
}
