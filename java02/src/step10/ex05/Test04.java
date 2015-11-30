package step10.ex05;

import java.util.Hashtable;

public class Test04 {
  public static void main(String[] args) {
    Hashtable map = new Hashtable();
    map.put(1, "홍길동");
    map.put(2, "홍길동");
    // map.put(3, null);         // 오류! 값으로 null을 저장할 수 없다.
    // map.put(4, null);
    // map.put(null, "임꺽정");
    // map.put(null, "임꺽정2");
    
    System.out.println(map.size());
    System.out.println(map.get(1));
    System.out.println(map.get(2));
    System.out.println(map.get(3)); // 해당 키의 값을 찾을 수 없으면 null 리턴
    System.out.println(map.get(4)); // 해당 키의 값을 찾을 수 없으면 null 리턴
    // System.out.println(map.get(null));
    
  }
}
