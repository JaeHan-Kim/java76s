package step09.v08;

import java.sql.Date;

public class Project {
  protected String projectname;
  protected Date   start_date;
  protected Date   end_date;
  protected String member;
  
  public Project() {}

  public String getProjectname() {
    return projectname;
  }

  public void setProjectname(String projectname) {
    this.projectname = projectname;
  }

  public Date getStart_date() {
    return start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getEnd_date() {
    return end_date;
  }

  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
  }

  public String getMember() {
    return member;
  }

  public void setMember(String member) {
    this.member = member;
  }

  @Override
  public String toString() {
    return "Student [projectname=" + projectname + ", start_date=" + start_date + ", end_date=" + end_date + ", member="
        + member + "]";
  }
 
  
  
  
}









