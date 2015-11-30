package step16.ex08.client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.net.Socket;

public class FileClient {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println(
          "사용법 : java [옵션들] step16.ex08.client.FileClient 파일경로/이름");
      return;
    }

    File file = new File(args[0]);
    try (
        FileInputStream in = new FileInputStream(file);
        BufferedInputStream buffer = new BufferedInputStream(in);
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        ){
      int len = 0;
      System.out.println(file.length());
      out.println(file.getName());
      out.println(file.length());

      while((len = buffer.read()) != -1) {
        out.println(len);
      }
     // out.println(-1);

      System.out.println("전송 완료!");

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
