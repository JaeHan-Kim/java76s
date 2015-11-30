/* 
 * 주제: 파일 정보 다루기 - File
 */
package step02;

import java.io.File;

public class Exam06 {
  public static void main(String[] args) {
    //1) 파일 또는 디렉토리 정보를 준비한다.
    //File f1 = new File("C:/javaide");
    File f1 = new File("C:/javaide/Hello2.java");
    
    System.out.println(f1.exists());
    System.out.println(f1.isDirectory());
    System.out.println(f1.isFile());
    System.out.println(f1.canWrite());
    System.out.println(f1.getParent());
    System.out.println(f1.length());
    f1.delete();
  }
}
