package step10.ex05;

import java.util.ArrayList;

public class Test01 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add(1); // auto-boxing
    list.add("홍길동");
    list.add(true); // auto-boxing
    list.add(null);
    list.add(null);
    list.add("홍길동"); // 중복값 저장 가능
    
    Integer v1 = (Integer)list.get(0);
    String v2 = (String)list.get(1);
    Boolean v3 = (Boolean)list.get(2);
    int v4 = (Integer)list.get(0); // auto-unboxing
    boolean v5 = (Boolean)list.get(2);
    String v6 = (String)list.get(5);
    
    System.out.printf("크기 : %d\n", list.size());
    System.out.println(v1);
    System.out.println(v2);
    System.out.println(v3);
    System.out.println(v4);
    System.out.println(v5);
    System.out.println(v6);
    
  }
}
