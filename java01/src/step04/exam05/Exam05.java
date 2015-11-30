/*
 * 주제: 도구 생성
 * - class
 */
package step04.exam05;
class A {
  static String hello(String name) {
    return "안녕하세요. " + name + "님!";
  } 
}
public class Exam05 {
  public static void main(String[] args) {
    String str = A.hello("김재한");
    System.out.println(str);
  }
}
