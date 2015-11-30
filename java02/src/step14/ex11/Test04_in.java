package step14.ex11;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test04_in {

  public static void main(String[] args) throws Exception{
    FileInputStream in = new FileInputStream("./test/exam11.test04.dat");
    ObjectInputStream in2 = new  ObjectInputStream(in);
    
    Score s1 = (Score)in2.readObject();
    
    System.out.println(s1);
    
    s1.compute();
    System.out.println(s1);
    in2.close();
    in.close();
    
  }

}
