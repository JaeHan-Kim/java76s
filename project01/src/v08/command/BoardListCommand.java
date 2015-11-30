package v08.command;

import java.util.ArrayList;
import java.util.HashMap;

import v08.dao.BoardDao;
import v08.domain.Board;

public class BoardListCommand implements Command{
  BoardDao boardDao = null;
  public void setBoardDao(BoardDao boardDao) {
      this.boardDao = boardDao;
  }
  public void execute(HashMap<String,Object> params) {
    ArrayList<Board> list = boardDao.selectList();
    
    Board Board = null;
    System.out.printf("%-3s %-20s %-10s %-10s %-10s\n", 
        "No", "Title", "Content", "Date", "Write");
    for (int i = 0; i < list.size(); i++) {
      Board = list.get(i); // 제네릭 적용! 타입 캐스팅 필요 없다.
      if (Board == null) 
        continue;
      System.out.printf("%3d %-20s %-10s %-10s %-10s\n", 
          i, 
          Board.getTitle(),
          Board.getContent(),
          Board.getCreatedDate(),
          Board.getWriter());
    }
  }
}
