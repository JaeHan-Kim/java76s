package step10.ex08;

import java.util.ArrayList;

public class Test03 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("홍길동0");
    list.add("홍길동1");
    list.add("홍길동2");
    list.add("홍길동3");
    list.add("홍길동4");
    list.add("홍길동5");
    list.add("홍길동6");
    
    for (int index = (list.size() - 1); index >= 0; index--) {
        System.out.println(list.get(index));
    }
  }
}
