/*
 * 작업 목표 : 
 * - 사용자에게 명령 프롬프트를 출력한다.
 * - quit이라는 명령어를 입력할 떄까지
 */
package step09.v01;

import java.util.Scanner;

public class ProjectApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String command;
    do{
      System.out.print("명령> ");
      command = scanner.nextLine();
      System.out.println(command);
    }while(!(command.equals("quit")));
  
    System.out.println("안녕히가세요!");
    scanner.close();
  }

}
