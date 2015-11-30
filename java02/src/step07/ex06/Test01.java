/*
 * 주제: 상속 관계에서 인스턴스 변수 준비
 */
package step07.ex06;

public class Test01 {

  public static void main(String[] args) {
    A p1 = new A();
    B p2 = new B();
    //C p3 = new C(); // 오류! C클래스는 기본 생성자가 없
    D p4 = new D();
    
  }

}
