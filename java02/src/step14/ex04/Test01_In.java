package step14.ex04;

import java.io.FileInputStream;
import java.io.FileReader;

public class Test01_In {
  public static void main(String[] args) throws Exception{
    // FileReader 시용법
    FileInputStream in = new FileInputStream("./test/ex04.test01.txt");
 
    
    System.out.printf("%04x\n", in.read());
    System.out.printf("%04x\n", in.read());
    System.out.printf("%04x\n", in.read());
    in.close();
    
    // FileeInputStream의 read()
    // => 데이터의 저장 형식에 상관없이 1바이트를 읽는다.
    
    System.out.println("----------------------------");
    
    FileReader in2 = new FileReader("./test/ex04.test01.txt");
    System.out.printf("%04x\n", in2.read());  // ecb39d(UTF-8) --> ccdd(unicode)
    System.out.printf("%04x\n", in2.read());  // 41(UTF-8) --> 0041(unicode)
    System.out.printf("%04x\n", in2.read());  // eabo80(UTF-8) --> AC00(unicode)
    in2.close();
    
    // FileReader의 read()
    // 읽은 데이터를 문자라고 간주하고 유니코드로 바꾼다.
    // => 읽을 때 UTF-8(JVM 기분 문자집합)의 규칙에 따라 읽는다.
    // 규칙? 영어는 1바이트, 한글은 3바이트.
  }
}
