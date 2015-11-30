package step16.ex02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
   // Socket socket = null;
    BufferedReader in = null;
    PrintStream out =  null;
    
    try (
        Socket socket = new Socket("192.168.0.50", 8888);
        ){
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintStream(socket.getOutputStream());
      
      // 3) 서버에 요청하기
        out.println("Hello!");
      
      // 4) 서버로 부터 응답 받기
      String message = in.readLine();
      
      // 5) 서버가 응답한 메시지 출력하기
      System.out.println(message);
      
    } catch(Exception e) {
      e.printStackTrace();
      
    }finally {
      try{in.close();} catch (Exception e){}

      try{out.close();} catch (Exception e){}

    }

  }
}
