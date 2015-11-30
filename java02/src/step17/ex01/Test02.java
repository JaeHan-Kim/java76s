/*
 * 자바에서 스레드 구현하는 방법
 * 1) Thread를 상속받기
 * 2) Runnable 인터페이스를 구현하기
 */
package step17.ex01;

public class Test02 {
  
  public static void main(String[] args) {
    Thread main = Thread.currentThread();
    System.out.println("현재 스래드명 :" + main.getName());
    
    // 스레드 그룹?
    // - 스레드가 소속되어 있는 그룹
    ThreadGroup tg = main.getThreadGroup();
    System.out.println("main 스레드의 그룹명 : " + tg.getName());
  }
}
