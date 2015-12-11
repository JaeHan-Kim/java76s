package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;


public class Contents implements Serializable{
  private static final long serialVersionUID = 1L;
  
  protected int 			cno;
  protected int 			contents_uno;
  protected int       read_count;
  protected int       views;
  protected int       likes;
  protected String 		title;
  protected String 		content;
  protected Date 			cre_dt;
  protected String    video;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getContents_uno() {
		return contents_uno;
	}
	public void setContents_uno(int contents_uno) {
		this.contents_uno = contents_uno;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCre_dt() {
		return cre_dt;
	}
	public void setCre_dt(Date cre_dt) {
		this.cre_dt = cre_dt;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	@Override
	public String toString() {
		return "Contents [cno=" + cno + ", contents_uno=" + contents_uno + ", read_count=" + read_count + ", views=" + views
		    + ", likes=" + likes + ", title=" + title + ", content=" + content + ", cre_dt=" + cre_dt + ", video=" + video
		    + "]";
	} 

}