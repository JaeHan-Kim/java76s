/*
 * 주제 : 인스턴스 변수
 * - 
 */
package step07.ex03;

public class Test {
  public static void main(String[] args) {
    // 10 + 2 - 7 = ?
    // 8 - 6 + 3 = ?
    
    
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    Calculator.plus(c1, 10);
    Calculator.plus(c1, 2);
    Calculator.minus(c1, 7);
    
    
    Calculator.plus(c2, 8);
    Calculator.minus(c2, 6);
    Calculator.plus(c2, 3);
    
    // result를 인스턴스 변수로 선언하면
    // plus(), minus()의 작업 결과를 별개로 관리할 수 있다.
    System.out.println(c1.result);
    System.out.println(c2.result);
  }
}