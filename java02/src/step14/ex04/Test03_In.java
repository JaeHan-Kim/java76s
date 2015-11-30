package step14.ex04;

import java.io.FileReader;

public class Test03_In {
  public static void main(String[] args) throws Exception {
    FileReader in = new FileReader("./test/ex04.test03.txt");
    
    char[] chars = new char[100];
    int len = 0;
    len = in.read(chars);
    
    String str = new String(chars, 0, len);
    System.out.println(str);
    
    in.close();
  }
}
