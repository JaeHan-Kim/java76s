package v11.server.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;

import v11.server.annotation.Component;
import v11.server.dao.BoardDao;
import v11.server.domain.Board;


public class BoardAddServlet implements Servlet{
  BoardDao boardDao = null;
  public void setBoardDao(BoardDao boardDao) {
      this.boardDao = boardDao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    Board board = new Board();
    PrintStream out = (PrintStream)params.get("out");
   
    board.setTitle((String)params.get("title"));

    board.setContent((String)params.get("content"));

    board.setCreatedDate(Date.valueOf((String)params.get("date")));

    board.setWriter((String)params.get("write"));
    
    boardDao.insert(board);
    out.println("저장되었습니다.");
  }
}
