package v09.server.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import v09.server.dao.BoardDao;

public class BoardDeleteServlet implements Servlet{
  BoardDao boardDao = null;
  public void setBoardDao(BoardDao boardDao) {
      this.boardDao = boardDao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    int no = Integer.parseInt((String)params.get("no"));

    PrintStream out = (PrintStream)params.get("out");
    
    try {
      boardDao.delete(no);
      out.println("삭제하였습니다.");
    } catch (Exception e) {
      out.println("해당 번호의 프로젝트가 존재하지 않습니다.");
    }
  }
}
