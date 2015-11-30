package step12.ex04;

public class Test03 {

  // 여러 개 프로퍼티 선언하기
  static @interface MyAnno {
    String value();
    int age();
  }

  // 예1 :
  // => 여러 개의 프로미터 값을 지정할 때는 콤마(,)로 구분한다.
  @MyAnno (
      value = "테스트",
      age = 20
      )
  static class MyClass {}

  // 예2 :
  // => 모든 프로포타 값을 지정해야한다.
  // @MyAnno (value = "홍길동")
  // @MyAnno (age = 20)
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
