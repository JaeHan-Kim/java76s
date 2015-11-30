package step12.ex02;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test04episode02 {

  public static void printScore (String name, int... valueList) {
    System.out.println("plus(int...)");
    int sum = 0;
    for (int i : valueList) {
      sum += i;
    }
    System.out.printf("%s, %d \n", name, sum);
  }
  // "varargs(아규먼트 목록)"은 항상 파라미터 선언에 맨 마지막에 와야 한다.
  // public static void printScore2 (int... valueList, String name) {}
  // public static void printScore3 (String name, int... valueList, boolean b) {}  
  
  public static void main(String[] args) throws Exception{
    printScore("홍길동");
    printScore("임꺽정", 100, 90);
    printScore("유관순", 100, 90, 80); 
    // printScore("오호라", 100, 90, true);
   
  }
}