package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.BoardDao;

@Component("/board/delete")
public class BoardDeleteServlet implements Servlet{
  BoardDao boardDao = null;
  public void setBoardDao(BoardDao boardDao) {
      this.boardDao = boardDao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    int no = Integer.parseInt((String)params.get("no"));

    PrintStream out = (PrintStream)params.get("out");
    
    if (boardDao.delete(no)>0) {
      out.println("삭제하였습니다.");
    } else {
      out.println("해당 번호의 프로젝트가 존재하지 않습니다.");
    }
  }
}
