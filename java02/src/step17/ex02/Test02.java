/*
 * CPU racing(CPU 사용권을 얻기 위헤 경쟁하는 것)
 * --> 스레드는 프로세스와 동일한 자격으로 CPU 쟁탈전에 참여한다.
 * --> OS의 스케줄링 방식에 따라 다르다. 
 */
package step17.ex02;

public class Test02 {
  // 스레드 정의 2 - Runnable 인터페이스 구현하기
  // => Thread가 실행할 코드를 갖고 있는 객체!
  static class MyRunnable implements Runnable {
    String name;
    public MyRunnable(String name) {
      this.name = name;
    }
    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println(this.name + " : " + i);
      }
    }
  }
  public static void main(String[] args) {
    
    MyRunnable r = new MyRunnable("t1");
    Thread t1 = new Thread(r);
    
    // => 쓰레드 시작 => Thread에 장착된 MyRunnablr
    t1.start();
    for (int i = 0; i < 100; i++) {
      System.out.println("***********");
    }
  
  }
}
