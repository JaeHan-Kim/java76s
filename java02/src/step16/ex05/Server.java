package step16.ex05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
  static class EchoAgent implements Runnable{
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
        String message =null;
        while (true) {
          message = in.readLine();
          System.out.println(message);
          if (message.endsWith(":bye")) {
            out.println("안녕히 가세요!");
            break;
          }
          out.println(message);
        }
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
  public void service() {
    try (
        ServerSocket ss = new ServerSocket(8888, 5);)
    {
      System.out.println("클라이언트의 연결 기다림...");
      Socket socket = null;

      while (true) {
        socket = ss.accept();
        new Thread(new EchoAgent(socket)).start();

        /*
        EchoAgent agent = new EchoAgent(socket);
        Thread t =new Thread(agent);
        t.start();
         */
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





