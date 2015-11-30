/*
 * 주제: 자바 핵심 클래스 - 랩퍼 클래스 (1)
 * - Wrapper class?
 *   => primitive 타입의 값을 다루는 클래스
 *      byte    ----> Byte
 *      short   ----> Short
 */
package step06;


public class Exam12 /* extends Object*/{
  public static void main(String[] args) {
    // 랩퍼 클래스는,
    // 이렇게 원스 타입의 값을 다루는 다양한 메서드를 보유하고 있다.
    // => 원시 타입의 값을 다양한 방법으로 다루고 싶을 때 사용한다.
   
    int i = 10;
    Integer obj1 = new Integer(10);
    int i2 = obj1.intValue();
    boolean b = true;
    Boolean obj2 = new Boolean(true);
    Boolean obj3 = new Boolean("true");
    boolean b2 = Boolean.getBoolean("flase");
    
  }
}
