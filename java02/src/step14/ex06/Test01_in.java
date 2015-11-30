package step14.ex06;

import java.io.FileInputStream;

public class Test01_in {
  public static void main(String[] args) throws Exception{
    // 캐싱 적용전
    FileInputStream in = new FileInputStream("./test/test.mp4");

    long start = System.currentTimeMillis();
    int b;
    while ((b = in.read()) != -1) ;
    long end = System.currentTimeMillis();
    System.out.println(end -start);
    in.close();
  }
}
