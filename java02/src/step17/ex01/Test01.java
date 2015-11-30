/*
 * 자바에서 스레드 구현하는 방법
 * 1) Thread를 상속받기
 * 2) Runnable 인터페이스를 구현하기
 */
package step17.ex01;

public class Test01 {
  
  public static void main(String[] args) {
    // "main" 스레드
    // => JVM이 직접 main() 메서드를 호출하는 것이 아니다.
    // => "main" 스레드에게 위임한다.
    // => JVM은 메모리나 스레드 등 자원을 관리를 수행한다.
    
    // main() 메서드를 홏출하는 스레드 알아내기
    Thread main = Thread.currentThread();
    System.out.println(main.getName());
  }
}
