package step07.ex03;

public class Calculator {
  int result; // 인스턴스 변수
  
  public static void plus(Calculator instance, int a){
    instance.result += a;
  }
  public static void minus(Calculator instance, int a){
    instance.result -= a;
  }
}
