package step12.ex04;

public class Test04 {

  // 프로퍼티를 선택 항목으로 만들기
  static @interface MyAnno {
    String value();
    int age() default 0; // age는 선택 항목이다. 반드시 값을 줄 필요가 없다.
  }

  // 예1 :
  // => age는 선택 항목이기 떄문에 값을 지정하지 않아도 된다.
  @MyAnno (value = "홍길동")
  static class MyClass {}

  // 예2 :
  // => 물론 value 프로퍼티의 값 만을 설정할 떄는 이름 생략 가능!
  @MyAnno ("홍길동")
  static class MyClass2 {}
  
  // 예3 :
  // => value 값만을 설정할 때는 이름을 생략할 수 있다.
  // => 그러나 여러 개의 프로퍼티 값을 설정할 떄는 value 이름을 생략할 수 없다.
  /*
  @MyAnno (
      "테스트", // 오류 !
      age = 20
      )
  */
  static class MyClass3 {}
  public static void main(String[] args) {

  }
}
