package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;


public class Plans implements Serializable{
  private static final long serialVersionUID = 1L;
  
  protected int 			pno;
  protected int 			no;
  protected String 		plan_title;
  protected String 		plan_content;
  protected Date 			d_day;
  protected Date   		createdDate;
  protected String    attachFile; // 컬럼명 = afile
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPlan_title() {
		return plan_title;
	}
	public void setPlan_title(String plan_title) {
		this.plan_title = plan_title;
	}
	public String getPlan_content() {
		return plan_content;
	}
	public void setPlan_content(String plan_content) {
		this.plan_content = plan_content;
	}
	public Date getD_day() {
		return d_day;
	}
	public void setD_day(Date d_day) {
		this.d_day = d_day;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
	@Override
	public String toString() {
		return "Plans [pno=" + pno + ", no=" + no + ", plan_title=" + plan_title + ", plan_content=" + plan_content
		    + ", d_day=" + d_day + ", createdDate=" + createdDate + ", attachFile=" + attachFile + "]";
	}

  
}