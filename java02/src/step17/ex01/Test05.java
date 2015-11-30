package step17.ex01;

public class Test05 {
  public static void main(String[] args) {
    Thread main = Thread.currentThread();
    Thread t1 = new Thread();
    
    System.out.println("최대 우선 순위 : " + Thread.MAX_PRIORITY);
    System.out.println("최소 우선 순위 : " + Thread.MIN_PRIORITY);
    System.out.println("기본 우선 순위 : " + Thread.NORM_PRIORITY);
    System.out.println("main의 우선 순위 : " + main.getPriority());
    System.out.println("t1의 우선 순위 : " + t1.getPriority());
  }
}
