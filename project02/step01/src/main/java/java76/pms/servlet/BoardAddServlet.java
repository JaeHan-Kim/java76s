package java76.pms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;


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
