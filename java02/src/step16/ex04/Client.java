package step16.ex04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {

    try (
        Socket socket = new Socket("192.168.0.60", 8888);    
        Scanner scanner = new Scanner(System.in);
        BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
        ){
      System.out.print("입력> ");
      out.print("김재한 : " + scanner.nextLine());
      String message = in.readLine();

      System.out.println(message);

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}