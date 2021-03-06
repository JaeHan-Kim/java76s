/*
 * 주제 : 기능 확장 - 곱셈과 나눗셈 기능을 추가하고 싶다.
 * 1) 기존 소스에 코드를 추가한다.
 *  => 기존 소스 파일이 없다면? 내가 만든 클래스, 우리 회사가 만든 클래스가 아니다.
 *  => 기존 소스 파일이 있다하더라도, 기존 소스를 손대면 잘 동작하던 기능이 인 될 가능성이 있다.
 * 2) 기존 코드를 상속 받아서 기능을 추가한다. - 상속(Inheritance)
 *  => 기존 소스 파일이 없어소 된다. 바이트코드(.class)만 있으면 된다.
 *  => 기존 소스를 손대지 않기 때문에 기존 기능에 문제가 발생할 가능성이 낮다.
 *  => 손쉽게 기능을 추가(확장)할 수 있다.
 */
package step07.ex05;

public class Test {
  public static void main(String[] args) {
    // 10 + 2 - 7 = ?
    
    Calculator3 c1 = new Calculator3();

    c1.plus(10);      // Calculator2의 plus() 
    c1.minus(6);      //  Calculator2의 minus()
    c1.multiple(7);   //  Calculator3의 multiple()
    c1.divide(2);     //  Calculator3의 divide()
    
    System.out.println(c1.result);
  }
}