/*
 * 주제: 자바 핵심 클래스 - String (3)
 */
package step06;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam03 {

  public static void main(String[] args) {
    String s1 = new String("Hello");

    // immutable : 값을 바꿀 수 없다.
    // => String 인스턴스는 한 번 생성되면 값을 바꿀 수 없다.
    // => immutable 객체라 부른다.
    // 예)
    String s2 = s1.replace('l', 'x');
    System.out.println(s1);
    // replace(): 기존의 문자열을 바꾸는 것이 아니라, 새로운 문자열 인스턴스를 생성한다.
    System.out.println(s2);
    
    // 자주 사용하는 문자열 메소드
    String s3 = s1.substring(2);  // 2번 문자부터 끝까지 추출하여 새로 인스턴스를 만든다.
    System.out.println(s3);
    
    String s4 = s1.substring(1, 3); // 1 <= x < 3 
    System.out.println(s4);
    
    System.out.println(s1.indexOf('e'));
    System.out.println(s1.indexOf('l'));
    
    System.out.println(s1.lastIndexOf('l'));
    
    // 퀴즈?
    // - 스캐너로부터 한 줄 입력 받는다.
    // - 해당 문자열이 이메일인지 확인한다.
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("입력하시오>");
    String str = scanner.nextLine();
    scanner.close();
    
    /*
    System.out.println(str.indexOf('@'));
    System.out.println(str.lastIndexOf('.'));
    if ((str.indexOf('@')) != -1 && (str.indexOf('@')>=4)){
      if (str.lastIndexOf('.')!= -1 && ((str.lastIndexOf('.')-str.indexOf('@'))>=3)) {
        System.out.println("이메일");
      }
    }
    else{
      System.out.println("이메일 아님");
    }
     */
    
    Pattern p = Pattern.compile("^[a-zA-Z0-9.-_]+@[a-zA-Z0-9]+\\.[a-zA-Z.]+$");
    Matcher m = p.matcher(str);
    
    if (m.matches()) {
      System.out.println("이메일");
    }
    else{
      System.out.println("이메일 아님");
    }
  } 
}
