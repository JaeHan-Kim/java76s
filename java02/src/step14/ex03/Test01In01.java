package step14.ex03;

import java.io.FileInputStream;

public class Test01In01 {
  public static void main(String[] args) throws Exception{
    //FileInputStream 도구 사용법
    // => 데이터를 읽어들일 때 사용하는도구
    // => 지정한 파일이 존재하지 않으면 예외 발생!
    FileInputStream in = new FileInputStream("./test/ex03.test01.txt");
    
    // 1) 1바이트 읽기
    // => read(): int => 리턴 타입이 int라고 해서 4바이트를 읽어서 리턴하는 것은 아니다.
    //                   오직 1바이트를 읽어 리턴한다.
    int b = in.read();
    System.out.println(Integer.toHexString(b));
    
    b = in.read();
    System.out.println(Integer.toHexString(b));
    
    b = in.read();
    System.out.println(Integer.toHexString(b));
    
    b = in.read();
    System.out.println(Integer.toHexString(b));
    
    b = in.read();
    System.out.println(Integer.toHexString(b));
    
    b = in.read();
    System.out.println(Integer.toHexString(b));
    
    b = in.read();
    System.out.println(Integer.toHexString(b));
    
    in.close();
    System.out.println("실행완료!");
  }
}
