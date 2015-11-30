/*
 * 주제: 기능정의4
 * -  Function = Method
 * -  문법
 */
package step04;

public class Exam04 {
  
  // 2) 메서드 정의
  // return: 있음 
  // parameter: 있음
  static String hello(String name) {
    return "안녕하세요. " + name + "님!";
  } 
  
  public static void main(String[] args) {
    String str = hello("김재한");
    System.out.println(str);
  }
}
