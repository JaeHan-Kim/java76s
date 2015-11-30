package step12.ex04;

public class Test05 {

  // 배열 데이터 저장하기
  static @interface MyAnno {
    String[] value();
    int[] age() default 0;
  }

  // 예1 :
  // => 배열의 값은 중괄호({}) 안에 나열한다.
  @MyAnno (value = {"홍길동","임꺽정","유관순"})
  static class MyClass {}

  // 예2 :
  // => 배열의 값은 중괄호({}) 안에 나열한다.
  @MyAnno ({"홍길동","임꺽정","유관순"})
  static class MyClass2 {}

  // 예3 :
  // => 배열 값이 한 개일 때 중괄호를 뺴도 된다.
  // @MyAnno({"홍길동"}) // 기본!
  @MyAnno ("홍길동")  // 중괄호 생략
  // @MyAnno ("홍길동","임꺽정") // 오류!
  static class MyClass3 {}

  //@MyAnno (value = {"홍길동"}, age = {20})
  //@MyAnno (value = "홍길동", age = 20)
  @MyAnno (
      value = {"홍길동","임꺽정","유관순"}, 
      age = {20,30,40})
  static class MyClass4 {}
  public static void main(String[] args) {

  }
}
