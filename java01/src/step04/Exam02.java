/*
 * 주제: 기능정의2
 * -  Function = Method
 * -  문법
 */
package step04;

public class Exam02 {
  
  // 2) 메서드 정의
  // return: 없음 
  // parameter: 있음
  static void hello(String name) {
    System.out.println("안녕하세요." + name + "님");
  } 
  
  public static void main(String[] args) {
    hello("김재한"); // 메서드 호출
    // "김재한" - 메서드 호출할 때 넘기는 값 => argument
    
  }
}
