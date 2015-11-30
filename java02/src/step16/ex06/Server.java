package step16.ex06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/* Runnable 인터페이스를 구현하여 클라이언트 요청 처리
 * 실습:
 * 1) main 메서드의 작업을 Server 클래스의 메서드로 만들기
 * 2) MyThread가 하던 일을 Runnable 인터페이스 구현으로 대체하기
 */
public class Server  {
  static class EchoAgent implements Runnable {
    Socket socket;
    
    public EchoAgent(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      BufferedReader in = null;
      PrintStream out = null;
      
      try {
        System.out.println("클라이언트와 연결됨.");
        
        in = new BufferedReader(
                new InputStreamReader(
                  socket.getInputStream()));
        
        out = new PrintStream(socket.getOutputStream()); 
        
        String message = null;
        HashMap<String, String> t = new HashMap<String, String>();
   
          message = in.readLine();
          System.out.println(message);
          String[] params = message.split("&");
          String[] param = null;
          System.out.println(params[0]);
          int result = 0;
          for (int i = 0; i < params.length; i++) {
            param = params[i].split("=");
            System.out.println(param[0]);
            t.put(params[0], params[1]);
          }
          int a = Integer.parseInt(t.get("a"));
          int b = Integer.parseInt(t.get("b"));
          System.out.println(a);
          switch (t.get("op")) {
          case "+": result = a + b; break; 
          case "-": result = a - b; break; 
          case "/": result = a / b; break; 
          case "*": result = a * b; break; 
          }
          out.println(result);
      } catch (Exception e) {
        e.printStackTrace();
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  public void service() {
    try (ServerSocket ss = new ServerSocket(8888);) 
    {
        System.out.println("클라이언트의 연결 기다림...");
        Socket socket = null;
        
        while (true) {
          socket = ss.accept();
          new Thread(new EchoAgent(socket)).start();
        }
        
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    Server server = new Server();
    server.service();
  }
}





