/*
 * 주제 : 인스턴스 aptjem
 *  - 인스턴스를 사용하는 메서드는 인스턴스 메서드로 선언하라!
 * - 
 */
package step07.ex04;

public class Test {
  public static void main(String[] args) {
    // 10 + 2 - 7 = ?
    // 8 - 6 + 3 = ?
    
    
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(10);  // c1 레퍼런스에 들어있는 주소는 plus()를 호출할 때 this에 저장된다.
    c1.plus(2);
    c1.minus(7);
    // 표현!
    // 1) c1에 들어있는 주소를 줄테니 그 주소의 인스턴스를 사용하여 plus()작업을 수행하라.
    // 2) c1이 가리키는 인스턴스를 가지고 plus() 작업을 수행하라.
    // 3) c1 인스턴스를 가지고 plus() 작업을 수행하라.
    // 4) c1 인스턴스에 대해 plus() 작업을 수행하라.
    // 5) c1 에 대해 plus()를 호출하라.
    // 6) c1 객체에 plus 메시지를 보내라.
    
    c2.plus(8); // c2 레퍼런스에 들어있는 주소는 plus()를 호출할 때 this에 저장된다.
    c2.minus(6);
    c2.plus(3);
    
    // result를 인스턴스 변수로 선언하면
    // plus(), minus()의 작업 결과를 별개로 관리할 수 있다.
    System.out.println(c1.result);
    System.out.println(c2.result);
  }
}