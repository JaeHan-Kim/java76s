package v09.server.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import v09.server.dao.BoardDao;
import v09.server.domain.Board;

public class BoardListServlet implements Servlet{
  BoardDao boardDao = null;
  public void setBoardDao(BoardDao boardDao) {
      this.boardDao = boardDao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    out.printf("%-3s %-20s %-10s %-10s %-10s\n", 
        "No", "Title", "Content", "Date", "Write");
    
    int i = 0;
    for (Board Board : boardDao.selectList()) {
      if (Board == null) 
        continue;
      out.printf("%3d %-20s %-10s %-10s %-10s\n", 
          i++, 
          Board.getTitle(),
          Board.getContent(),
          Board.getCreatedDate(),
          Board.getWriter());
    }
  }
}
