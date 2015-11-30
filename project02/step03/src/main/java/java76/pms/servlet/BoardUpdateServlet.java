package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

@Component("/board/update")
public class BoardUpdateServlet implements Servlet{
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
    board.setNo(Integer.parseInt((String)params.get("no")));
    board.setPassword((String)params.get("password"));
    
    if (boardDao.update(board) > 0) {
      out.println("변경되었니다.");
    } else {
      out.println("해당 게시물이 존재하지 않거나 암호가 맞지 않습니다.");
    }
  }
}
