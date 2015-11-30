package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

public class BoardAddServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {   
    try {
      Board board = new Board();
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
                                  .getAttribute("iocContainer");
      BoardDao boardDao = iocContext.getBean(BoardDao.class);
      board.setTitle((String)request.getParameter("title"));
      board.setContent((String)request.getParameter("content"));
      board.setPassword((String)request.getParameter("password"));

      boardDao.insert(board);
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
