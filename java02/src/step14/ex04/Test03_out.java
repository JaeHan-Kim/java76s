package step14.ex04;

import java.io.FileWriter;
import java.nio.charset.Charset;

public class Test03_out {
  public static void main(String[] args) throws Exception {
    // FileWtriter와 FileOutputStream의 출력비교!
    FileWriter out = new FileWriter("./test/ex04.test03.txt");

    // write(String) 
    // => 유니코드 문자열을 출력한다.
    String str = "ABC\nabc\n가각간\n똘똠똥\n";
    for (byte c: str.getBytes("UTF-16")) {
      System.out.printf("%02x", c);
    }
    // feff는 유니코드 를 표시하기 알려주기 위해 부차적으로 붙은 데이터이다. 일단 무시한다.
    // feff004100420043000a006100620063000aac00ac01ac04000ab618b620b625000a
    out.write(str); // Unicode ---> UTF-8 출력
    
    out.close();

    System.out.println("실행완료");    
  }
}
