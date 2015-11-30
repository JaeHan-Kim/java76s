/*
 * 주제: 기능정의3
 * -  Function = Method
 * -  문법
 */
package step04;

public class Exam03 {
  
  // 2) 메서드 정의
  // return: 있음 
  // parameter: 없음
  static String hello() {
    // 리턴 타입이 있으면 반드시 해당 타입의 데이터를 리턴해야 한다.
    return "안녕하세요.";
    // return 10;  // 다른 타입의 데이터를 리턴하면 문법 오류!
  } 
  
  public static void main(String[] args) {
    hello(); // 메서드 호출를 호출했지만 리턴 값을 사용하지 않는 예.
    
    String str = hello();
    
    System.out.println(str);
  }
}
