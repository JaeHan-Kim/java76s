package step10.ex08;

import java.util.ArrayList;

public class Test01 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("홍길동0");
    list.add("홍길동1");
    list.add("홍길동2");
    list.add("홍길동3");
    list.add("홍길동4");
    list.add("홍길동5");
    list.add("홍길동6");
    
    for (int index = 0; index < list.size(); index++) {
      if ((index % 2) == 0) {
        System.out.println(list.get(index));
      }
    }
  }

}
