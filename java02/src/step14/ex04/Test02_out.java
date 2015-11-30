package step14.ex04;

import java.io.FileOutputStream;

public class Test02_out {
  public static void main(String[] args) throws Exception {

    FileOutputStream out = new FileOutputStream("./test/ex04.test02.txt");
    
    out.write(0xaabbccdd); 
    out.write(0xaabb0041); 
    out.write(0xaabbAC00);
    
    out.close();
    
    System.out.println("실행완료");    
  }
}
