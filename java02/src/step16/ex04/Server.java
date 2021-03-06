/* 멀티 스레딩
 *  - 동시에 작업을 수행해야 하는 코드를 지정하기
 *  - 문법 : 
 *  Thread 클래스를 상속 받아서 run() 메서드를 오버라이딩한다.
 *  run()메서드에 코드를 넣는다.
 *          
 */
package step16.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
  static class MyThread extends Thread{
    Socket socket;
    public MyThread(Socket socket) {
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
        
        String message = in.readLine();
        System.out.println(message);
        
        out.println(message);
        
      } catch (Exception e) {
        e.printStackTrace();
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }

  }
  public static void main(String[] args) {
    try (
      ServerSocket ss = new ServerSocket(8888, 5);
    ) {
      System.out.println("클라이언트의 연결 기다림...");
      Socket socket = null;
      Scanner scanner = new Scanner(System.in);
     // MyThread t = null;
      while (true) {
        socket = ss.accept();
        new MyThread(socket).start();
       /* 
        t = new MyThread(socket);
        
        t.start();
        */
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}





