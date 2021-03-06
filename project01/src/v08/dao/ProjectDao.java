package v08.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import v08.Exception.DaoException;
import v08.domain.Project;

public class ProjectDao {
  String filename = "./data/project.dat";
  ArrayList<Project> list = new ArrayList<Project>();
  public ProjectDao() {
    try (    
        FileReader in = new FileReader(filename);
        BufferedReader in2 = new BufferedReader(in);
        ){
      String line = null;

      while ((line = in2.readLine()) != null) {
        list.add(new Project(line));
      }
    }catch(Exception e) {
      throw new DaoException("프로젝트정보 로딩 실패!");
    }
  }
  public void save(){
    try ( 
        FileWriter out = new FileWriter("./data/project.dat");
        BufferedWriter out2 = new BufferedWriter(out);
        PrintWriter out3 =new PrintWriter(out2);
        ){
      for (Project s : list) {
        out3.println(s);
      }
    }catch (Exception e) {
      throw new DaoException("프로젝트정보 저장 실패");
    }
  }
  public ArrayList<Project> selectList() {
    return list;
  }
  public void insert(Project project) {
    list.add(project);
  }
  public Object delete(int no) {
    return list.remove(no);
  }
  
}
