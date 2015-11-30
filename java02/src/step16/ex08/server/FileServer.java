package step16.ex08.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
  public class FileAgent extends Thread {
    Socket socket;
    public FileAgent(Socket socket) {
      this.socket = socket;
    }
    @Override
    public void run() {
      FileOutputStream out;
      BufferedOutputStream buffer;
      try (
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
          ){
        System.out.println("클라이언트 연결!");
        String fileName = "c:/test2/"+in.readLine();
   //     File file = new File(fileName);
        long fileSize = Long.parseLong(in.readLine());
        
        System.out.println(fileSize);
        
        out = new FileOutputStream(fileName);
        buffer = new BufferedOutputStream(out);

        int len = 0;
        while((len = Integer.parseInt(in.readLine())) != -1) {
          buffer.write(len);
        }
        buffer.flush();

      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void service() {
    try (
        ServerSocket serverSocket = new ServerSocket(8888);
        ){
      System.out.println("클라이언트 연결 기다림~");
      while (true) {
        new FileAgent(serverSocket.accept()).start();
      }
      //System.out.println("클라이언트 끝!");

    } catch(Exception e) {
      e.printStackTrace();
    }

  }
  public static void main(String[] args) {
    FileServer fileServer = new FileServer();
    fileServer.service();
  }}
