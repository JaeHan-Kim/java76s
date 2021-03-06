package v08.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import v08.dao.ProjectDao;
import v08.domain.Project;

public class ProjectAddCommand implements Command {
  ProjectDao projectdao = null;
  public void setProjectDao(ProjectDao projectdao) {
    this.projectdao = projectdao;
  }
  public void execute(HashMap<String,Object> params) {
    Scanner scanner = (Scanner)params.get("scanner");
    ArrayList<Project> list = projectdao.selectList();
    
    Project project = new Project();
    
    System.out.print("프로젝트명? ");
    project.setTitle(scanner.nextLine());
    
    System.out.print("시작일? ");
    project.setStartDate(Date.valueOf(scanner.nextLine()));
    
    System.out.print("종료일? ");
    project.setEndDate(Date.valueOf(scanner.nextLine()));

    System.out.print("멤버? ");
    project.setMember(scanner.nextLine());
    
    System.out.print("정말 저장하시겠습니까?(y/n)");
    String yesno = scanner.nextLine();
    if (yesno.toLowerCase().equals("y")) {
      projectdao.insert(project); 
      System.out.println("저장되었습니다.");
      
    } else {
      System.out.println("취소하였습니다.");
    }
  }
}
