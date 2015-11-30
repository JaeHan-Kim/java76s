/*
 * 작업 목표 :
 * - 사용자에게 명령 프롬프트를 출력한다.
 * 
 */
package step09.v02;

import java.util.Scanner;

public class ProjectApp {

  public static void main(String[] args) {
    System.out.print("명령> ");
    Scanner scanner = new Scanner(System.in);
    String command = scanner.nextLine();
    System.out.println(command);
    scanner.close();
  }

}
