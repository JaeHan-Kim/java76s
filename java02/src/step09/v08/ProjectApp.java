/*
 * 작업 목표: delete 명령 처리 (3) - 삭제한 항목을 비우지 말고, 뒤의 항목을 앞으로 당길 것.
 */
package step09.v08;

import java.util.Scanner;
import java.sql.Date;

public class ProjectApp {
  Scanner scanner = new Scanner(System.in);
  
  Project[] porjects = new Project[1000];
  int pos; // 저장 위치

  public static void main(String[] args) throws Exception {
    ProjectApp app = new ProjectApp();
    app.service();
  }
  
  private void service() {
    String command = null;
    do {
      System.out.print("명령> ");
      command = scanner.nextLine(); 
      switch (command) {
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
        doQuit();
        break;
      default:
        System.out.println("해당 명령을 지원하지 않습니다.");
      }
    } while (!command.equals("quit"));
    
    System.out.println("안녕히가세요!");
    scanner.close();
  }

  private void doList() {
    System.out.println("No\tTitle\t\t\tStart\t\tEnd\t\t\tMembers");
    for (int i = 0; i < pos; i++) {
      if (porjects[i] == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      System.out.printf("%3d\t%-10s\t\t%s\t%s\t\t%s\n", 
          i, 
          porjects[i].projectname,
          porjects[i].start_date,
          porjects[i].end_date,
          porjects[i].member);
    }
  }
  
  private void doAdd() {
    Project student = new Project();
    System.out.print("프로젝트명? ");
    student.setProjectname(scanner.nextLine());
    
    System.out.print("시작일? ");
    student.setStart_date(Date.valueOf(scanner.nextLine()));
    
    System.out.print("종료일? ");
    student.setEnd_date(Date.valueOf(scanner.nextLine()));

    System.out.print("멤버? ");
    student.setMember(scanner.nextLine());
    
    System.out.print("정말 저장하시겠습니까?(y/n)");
    String yesno = scanner.nextLine();
    if (yesno.toLowerCase().equals("y")) {
      if (pos < porjects.length) { 
        porjects[pos++] = student;
        System.out.println("저장되었습니다.");
      } else {
        System.out.println("저장소가 모두 찼습니다.\n저장할 수 없습니다!");
      }
    } else {
      System.out.println("취소하였습니다.");
    }
  }
  
  private void doDelete() {
    System.out.print("프로젝트 번호? ");
    int no = Integer.parseInt(scanner.nextLine());
    
    System.out.print("정말 삭제하시겠습니까?(y/n)");
    String yesno = scanner.nextLine();
    if (yesno.toLowerCase().equals("y")) {
      if (no > -1 && no < pos) { 
        if (porjects[no] == null) {
          System.out.println("이미 삭제된 항목입니다.");
        } else {
          for (int i = no; i < (pos - 1); i++) {
            porjects[i] = porjects[i + 1];
          }
          pos--;
          System.out.println("삭제하였습니다.");
        }
      } else {
        System.out.println("유효하지 않은 번호입니다.");
      }
    } else {
      System.out.println("취소하였습니다.");
    }
  }
  
  private void doQuit() {
    
  }
  
  private void doHelp() {
    System.out.println("[사용법]");
    System.out.println("명령");
    System.out.println();
    System.out.println("[명령]");
    System.out.println("list         학생 목록을 리턴한다.");
    System.out.println("add          학생을 추가한다.");
    System.out.println("delete       학생을 삭제한다. ");
    System.out.println("quit         프로그램을 종료한다.");
  }

}
