package step16.ex01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


  public static void main(String[] args) {

    Socket socket = null;
    InputStream in = null;
    InputStreamReader in2 = null;
    BufferedReader in3 = null;
    OutputStream out = null;
    PrintStream out2 =  null;

    try (
        ServerSocket ss = new ServerSocket(8888);
        ) {
      // 1) 대기열에서 기다리고 클라이언트가 있다면 연결을 승인한다.
      // => 리턴 값 - 클라이언트와 연결된 소켓.
      System.out.println("클라이언트 연결 기다림 ....");
      socket = ss.accept();
      System.out.println("클라이언트와 연결됨");

      // 2) 
      // => 입력 스트림 도구 준비
      in = socket.getInputStream();
      // 바이트 스트림을 캐릭터 스트림에 연결할 때 사용
      in2 = new InputStreamReader(in);
      in3 = new BufferedReader(in2);

      // => 출력 스트림 도구 준비

      out = socket.getOutputStream();
      out2 = new PrintStream(out);

      String message = in3.readLine();
      System.out.printf("클라이언트로부터 받은 메시지 : %s \n", message);
      
      //4) 클라이언트로 메시지를 그대로 보낸다. - 메이리     
      out2.println(message);
      System.out.printf("서버가 보낸 메시지 : %s \n", message);
      
    }catch (Exception e){
      e.printStackTrace();

    } finally {
      try{in3.close();} catch (Exception e){}
      try{in2.close();} catch (Exception e){}
      try{in.close();} catch (Exception e){}

      try{out2.close();} catch (Exception e){}
      try{out.close();} catch (Exception e){}

      try{socket.close();} catch (Exception e){}
    }
  }
}
