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

}