/*
 * 주제 : 다형성 - 오버라이딩(overriding) (2)
 * - super.super.메서드() 문법은 없다.
 */
package step07.ex10;

public class Test2 {
  public static void main(String[] args) {
    // 문제 : 계산식을 출력하라! 
    Calculator6 cal = new Calculator6();
    cal.plus(10);       // Calculator2.plus(int)
    cal.plus(17.5f);    // Calculator2.plus(float)
    cal.multiple(2);    // Calculator2.multiple(int)
    cal.print();        // Calculator2.print()
  }
}
