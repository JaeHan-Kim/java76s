package step12.ex04;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Test07 {

  // 애노테이션 프로퍼티 값 추출하기
  // => 애노테이션의 기본 유지 정책은 "CLASS" 이기 떄문에 Runtime에서 꺼낼 수 없다.
  // => 런타임(실행 중에)에서 꺼내고 싶다면 유지 정책을 변경하라!
  @Retention(RetentionPolicy.RUNTIME)
  
  static @interface MyAnno {
    String value();
  }

  @MyAnno("테스트")
  static class MyClass {}
  
  public static void main(String[] args) {
    Class clazz = MyClass.class;
    Annotation[] annos = clazz.getAnnotations();
    
    // 애노테이션 정보를 추촐할 수 없다.
    // 이유? 클래스 파일(Test06$MyClass)
    MyAnno my = null;
    for (Annotation anno : annos) {
      System.out.println(anno.annotationType().getName());
      System.out.println(((MyAnno)anno).value());
    }
  }
}

/* 애노테이션 유지 정책
 * 1) RetentionPlolicy.SOURCE
 *    - 컴파일할 때 제거된다. 즉 클래스 파일에 포함되지 않는다.
 * 2)
 */ 
