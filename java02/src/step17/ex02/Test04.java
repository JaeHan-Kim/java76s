/*
 * CPU racing(CPU 사용권을 얻기 위헤 경쟁하는 것)
 * --> 스레드는 프로세스와 동일한 자격으로 CPU 쟁탈전에 참여한다.
 * --> OS의 스케줄링 방식에 따라 다르다. 
 */
package step17.ex02;

public class Test04 {
  static class MyThread extends Thread {
    public MyThread(String name) {
      super(name);
    }
    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println(this.getName() + " : " + i);
      }
    }
  }
  public static void main(String[] args) {
    MyThread t1 = new MyThread("t1");
    t1.start();

    // 스레드 생명주기(life cycle)
    // new Thread() ---start()---> Runnable 상태 ---wait(), sleep()--->
  }
}
