package step15.ex04;

public class Calculator2 {
  
  public static int plus(int a, int b) {
    return a + b;
  }
  
  public static int minus(int a, int b) {
    return a - b;
  }
  public static int multiple(int a, int b) {
    return a * b;
  }
  
  // 자바에서 제공하는 예외 클래스를 사용하는 대신, 
  public static int divide(int a, int b) throws CalculatorException {
    if (b ==0) {
      // 오류 정보륿  Exception 객체에 담아 던지기
      throw new CalculatorException("0으로 나눌 수 없습니다.");
    }
    return a / b;
  }
}
