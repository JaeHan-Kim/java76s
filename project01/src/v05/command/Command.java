package v05.command;

import java.util.HashMap;

// MenuControl가 호출하는 메서드를 정의한다.
// 예) ProjectControl, StudentControl이 호출하는 메서드

public interface Command {
  void execute(HashMap<String, Object> params);
} 
