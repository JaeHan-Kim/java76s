/*
 * 작업 목표 :
 */
package step09.v04;

import java.util.Scanner;

public class ProjectApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String command;
    do{
      System.out.print("명령> ");
      command = scanner.nextLine();
      switch (command) {
      case "help":
        helpPrint();
        break;
      case "list":
        doList();
        break;
      case "add":
        doAdd();
        break;
      case "delete":
        doDelete();
        break;
      case "quit":
        break;
      default:
        System.out.println("해당 명령어를 지원하지 않습니다!");
        break;
      }
    }while(!(command.equals("quit")));
  
    System.out.println("안녕히가세요!");
    scanner.close();
  }
  private static void doList() {
    System.out.println("목록입니다.");
  }
  private static void doAdd() {
    System.out.println("추가입니다.");
  }
  private static void doDelete() {
    System.out.println("삭제 입니다.");
  }
  private static void doQuit() {
    
  }
  private static void helpPrint() {
    System.out.println("[사용법]");
    System.out.println("명령");
    System.out.println();
    System.out.println("[명령]");
    System.out.println("list        학생 목록을 리턴한다.");
    System.out.println("add         학생을 추가한다.");
    System.out.println("delete      학생을 삭제한다.");
    System.out.println("quit        프로그램을 종료한다.");
  }
}
