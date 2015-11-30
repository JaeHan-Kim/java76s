/*
 * 주제: 기능정의
 * -  Function = Method
 * -  문법
 */
package step04;

public class Exam01 {
  
  // 1) 메서드 정의
  // return: 없음
  // parameter: 없음
  // parameter? 값을 받는 변수(메모리)를 가리킨다.
  static void hello() {
    System.out.println("Hello!");
  }
  
  public static void main(String[] args) {
    hello(); // 메서드 호출
    // 메서드 호출?
    // 메서드 블로 안에 선언된 명령어를 실행하라!
  }
}
