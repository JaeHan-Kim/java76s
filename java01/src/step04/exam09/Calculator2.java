package step04.exam09;

public class Calculator2 {
  // result 변수를 개별관리 변수로 선언한다. => state 명령을 제거라하!
  // static이 부지 않은 변수는 new 명령을 통해 준비된다.
  // static이 붙은 변수는 클래스를 사용할 때 자동으로 준비된다.
  
  int result; // 정수 메모리는 0으로 초기화된다.
  
  static void plus(Calculator2 that, int a){
    that.result = that.result + a;
  }
  static void minus (Calculator2 that, int a) {
    that.result = that.result - a;
  }
  static void multiple(Calculator2 that, int a){
    that.result = that.result * a;
  }
  static void devide(Calculator2 that, int a){
    that.result = that.result / a;
  }
}
