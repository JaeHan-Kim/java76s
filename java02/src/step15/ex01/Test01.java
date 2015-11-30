package step15.ex01;

public class Test01 {
  public static void main(String[] args) {
    int result = 0;
    result = Calculator.plus(10, 20);
    result = Calculator.multiple(result, 2);
    result = Calculator.divide(result, 0);
    
    // 메서드의 리턴 값으로 오류를 알림
    if (result == -12121255) {
      System.out.println("0으로 나눌 수 없다");
    } else {   
      System.out.println(result);
    }
    
    result = 0;
    result = Calculator.divide(24242510, -2);
    // 리턴 값을 오류를 알리는 것의 한계
    if (result == -12121255) {
      System.out.println("0으로 나눌 수 없다");
    } else {   
      System.out.println(result);
    }
  }
}
