package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

public class BoardAddServlet extends GenericServlet{
  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {   
    Board board = new Board();
    PrintWriter out = (PrintWriter)response.getWriter();
    BoardDao boardDao = ContextLoader.context.getBean(BoardDao.class);
    board.setTitle((String)request.getParameter("title"));
    board.setContent((String)request.getParameter("content"));
    board.setPassword((String)request.getParameter("password"));
    
    boardDao.insert(board);
    out.println("저장되었습니다.");
  }
}
