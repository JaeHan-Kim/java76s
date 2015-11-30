package step14.ex02;

import java.io.File;
import java.io.FileFilter;

public class Test07 {
  // 인스턴스를 단 한 번만 만든다면 익명 이너 클래스로 선언하라.
  static FileFilter fileFilter = new FileFilter() {
    @Override
    public boolean accept(File file) {
      if (file.isDirectory() || file.getName().endsWith(".class"))
        return true;
      return false;
    }
  };
  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./bin");

    // 문제: 클래스 이름만 출력하라! - 또 다른 방법
    // => .class 확장자는 출력하지 않는다.
    // => 패키지명을 포함하라.
    // 예) step14.ex02.Test04
    displayDirectory(file);
  }

  private static void displayDirectory(File file) {
    File[] files = file.listFiles(fileFilter);
    for (File f : files) {
      if(f.isFile()) {
        //  if (f.getName().endsWith(".class")) {
        System.out.println(f.toString()
            .replace(".class", "")
            .replace(System.getProperty("file.separator"), ".")
            .substring(6));
        //  }
      } else if (f.isDirectory()) {
        displayDirectory(f);
      }
    }
  }
}