/*
 * 주제 : 상속 기법을 사용하기 후 - Generalization
 * - 여러 클래스에 중복되는 변수나 메서드를 추출하여
 *   상위 클래스로 옮기는 것.
 * - 문제 : 
 *   Student와 Trainer 클래스의 공통 분모를 뽑아낸다.
 *   
 */
package step07.ex12;

public class Test {
  public static void main(String[] args) {
    Student s1 = new Student("s01", "1111", "s01@test.com", false);
    Trainer t1 = new Trainer("t01", "1111", "t01@test.com", 10000);
  }
}
