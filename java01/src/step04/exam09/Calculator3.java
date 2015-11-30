package step04.exam09;

public class Calculator3 {
  // result 변수를 개별관리 변수로 선언한다. => state 명령을 제거라하!
  // static이 부지 않은 변수는 new 명령을 통해 준비된다.
  // static이 붙은 변수는 클래스를 사용할 때 자동으로 준비된다.
  static int res1;
  int result; // 정수 메모리는 0으로 초기화된다.
  
  // 인스턴스 메서드 만들기
  // - static 명령(keyword)를 없애라.
  // - 인스턴스를 받을 변수를 선언할 필요가 없다.
  //   인스턴스 메서드로 선언하면 this라는 내장 변수가 자동으로 만들어진다.
  // - 빌트인 변수 this에 인스턴스가 저장된다.
  void plus(int a){
    this.result = this.result + a;
    res1 = this.result;
  }
  void minus (int a) {
    this.result = this.result - a;
    res1 = this.result;
  }
  void multiple(int a){
    this.result = this.result * a;
    res1 = this.result;
  }
  void devide(int a){
    this.result = this.result / a;
    res1 = this.result;
  }
}
