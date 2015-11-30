package step12.ex02;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test04episode01 {
  public static int plus (int a, int b) {
    System.out.println("plus(int, int)");
    return a + b;
  }
  
  // 같은 타입의 아규먼트를 여려 개 받을 때, 파라미터 문법!
  // => 다음은 0개 이상의 int 값을 받는 문법
  public static int plus (int... valueList) {
    System.out.println("plus(int...)");
    int sum = 0;
    for (int i : valueList) {
      sum += i;
    }
    return sum;
  }
  public static void main(String[] args) throws Exception{
    System.out.println(plus());
    System.out.println(plus(10));
 // int 값을 두 개 받는 메서드가 있기 때문에 그 메서드를 호출!
    System.out.println(plus(10, 20)); 
    System.out.println(plus(10, 20, 30));
    System.out.println(plus(10, 20, 30, 40));
    System.out.println(plus(10, 20, 30, 40, 50));
    System.out.println(plus(10, 20, 30, 40, 50, 60));
    
  }
}