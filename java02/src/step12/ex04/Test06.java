package step12.ex04;

import java.lang.annotation.Annotation;

public class Test06 {

  // 애노테이션 프로퍼티 값 추출하기
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
    for (Annotation anno : annos) {
      System.out.println(anno.annotationType().getName());
    }
  }
}
