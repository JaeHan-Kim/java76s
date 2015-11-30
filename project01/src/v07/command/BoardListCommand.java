package v07.command;

import java.util.ArrayList;
import java.util.HashMap;

import v07.Board;

public class BoardListCommand {
  public void execute(HashMap<String,Object> params) {
    ArrayList<Board> list = (ArrayList<Board>)params.get("list");
    
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
