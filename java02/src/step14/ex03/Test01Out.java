package step14.ex03;

import java.io.FileOutputStream;

public class Test01Out {
  public static void main(String[] args) throws Exception{
    //FileOutputStream 도구 사용법
    // => 기존의 파일이 있으면 덮어쓴다.
    // => 파일이 없으면 자동으로 생성한다.
    // => 파일을 생성할 디렉토리가 없다면 예외가 발생한다.
    FileOutputStream out = new FileOutputStream("./test/ex03.test01.txt");
    
    out.write(0xaabbccdd); // 파라미터 타입이 int이지만 실제 출력하는 것은 맨 끝 1바이트이다.
    
    byte[] bytes = new byte[]{0x48, 0x49, 0x7a, 0x7b};
    out.write(bytes);
    
    
    out.close();
    System.out.println("실행완료!");
  }
}
