package java76.pms.domain;

import java.io.Serializable;

public class Members implements Serializable{
  private static final long serialVersionUID = 1L;
  protected int 	 no;
  protected String name;
  protected String email;
  protected String photo; // 학생 사진파일명
  protected String password;
  
  

	public Members() {}
  
  public Members(String name) {
    this.name = name;
  }

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Members [no=" + no + ", name=" + name + ", email=" + email + ", photo=" + photo + ", password=" + password
		    + "]";
	}
  
  
  
}









