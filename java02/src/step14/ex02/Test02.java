package step14.ex02;

import java.io.File;

public class Test02 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File(".");
    StringBuffer s = new StringBuffer();
    // 문제: 모든 하위 파일(디렉토리 포함) 이름을 출력하라.
    //      단, 하위 파일에 대해 두 칸 들여쓰기를 적용하여 계층 구조로 출력하라!
    //      힌트) 재귀호출 사용하면  편하다.
    
    // 문제: 클래스 이름만 출력하라! .class 확장자는 출력하지않는다.
    // 예) Test04
    call(file, s);
  }
  public static void call(File file, StringBuffer s) {
    File[] files = file.listFiles();
    String s1;
    for (File f : files) {
     
      if (f.isDirectory()) {
       System.out.println(s+f.getName());
        call(f, s.append("  "));
      }
      else {
       
         System.out.println(s+f.getName());
       }
      }
    if (s.length() > 0) {
      s.deleteCharAt(s.length()-1);
      s.deleteCharAt(s.length()-1);
    }
  }
}

