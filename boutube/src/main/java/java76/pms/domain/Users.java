package java76.pms.domain;

import java.io.Serializable;

public class Users implements Serializable{
  private static final long serialVersionUID = 1L;
  protected int 	 uno;
  protected int 	 auth;
  protected int 	 total_like;
  protected String name;
  protected String nickname;
  protected String email; 
  protected String password;
  protected String rePassword;
  protected String read_list;
  protected String photo;
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public int getTotal_like() {
		return total_like;
	}
	public void setTotal_like(int total_like) {
		this.total_like = total_like;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRead_list() {
		return read_list;
	}
	public void setRead_list(String read_list) {
		this.read_list = read_list;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	@Override
	public String toString() {
		return "Users [uno=" + uno + ", auth=" + auth + ", total_like=" + total_like + ", name=" + name + ", nickname="
		    + nickname + ", email=" + email + ", password=" + password + ", rePassword=" + rePassword + ", read_list="
		    + read_list + ", photo=" + photo + "]";
	}
	
 
  
}









