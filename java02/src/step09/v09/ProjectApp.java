/*
 * 작업 목표: 학생관리와 프로젝트 관리를 합친다.
 */
package step09.v09;

import java.util.Scanner;

public class ProjectApp {
  Scanner scanner = new Scanner(System.in);
  StudentControl studentControl = new StudentControl(scanner);
  ProjectControl projectControl =  new ProjectControl(scanner);
  public static void main(String[] args) {
    ProjectApp app = new ProjectApp();
    app.service();
  }
  
  public void service() {
    String command = null;
    do {
      System.out.print("명령> ");
      command = scanner.nextLine(); 
      switch (command) {
      case "menu":
        domenu();
        break;
      case "menu 1":
        studentControl.service();
        break;
      case "menu 2":
        projectControl.service();
        break;
      case "help":
        doHelp();
        break;
      case "quit":
        doQuit();
        break;
      default:
        System.out.println("해당 명령을 지원하지 않습니다.");
      }
    } while (!command.equals("quit"));
    
    System.out.println("안녕히가세요!");
    scanner.close();
  }
  private void domenu() {
    System.out.println("1 회원 관리");
    System.out.println("2 프로젝트 관리");
  }
  
  private void doQuit() {
    
  }
  
  private void doHelp() {
    System.out.println("[사용법]");
    System.out.println("명령");
    System.out.println();
    System.out.println("[명령]");
    System.out.println("menu         메뉴 목록을 리턴한다.");
    System.out.println("menu 번호      해당 번호의 메뉴로 간다..");
    System.out.println("quit         프로그램을 종료한다.");
  }

}
