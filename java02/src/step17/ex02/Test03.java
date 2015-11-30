/*
 * CPU racing(CPU 사용권을 얻기 위헤 경쟁하는 것)
 * --> 스레드는 프로세스와 동일한 자격으로 CPU 쟁탈전에 참여한다.
 * --> OS의 스케줄링 방식에 따라 다르다. 
 */
package step17.ex02;
/* Runnable 인터페이스 구현이 이점
 * => 인터페이스이기 때문에 누구든지 Runnable이 될 수 잇다.
 *  
 */
public class Test03 implements Runnable{
    static String name = "t1";
    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println(Test03.name + " : " + i);
    }
  }
  public static void main(String[] args) {
    
    Test03 r = new Test03();
    Thread t1 = new Thread(r);
    
    // => 쓰레드 시작 => Thread에 장착된 MyRunnablr
    t1.start();
    for (int i = 0; i < 700; i++) {
      System.out.println("***********");
    }
  
  }
}
