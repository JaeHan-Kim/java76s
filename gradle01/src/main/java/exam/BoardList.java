package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardList {
  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java76db","java76", "1111");
      
      System.out.println("DBMS 연결 성공!");
      
      stmt = con.createStatement();
      System.out.println("SQL 실행 객체 준비 완료!");
      
      rs = stmt.executeQuery("select * from board");
      
      while (rs.next()) {
        System.out.printf("%d, %s, %s, %d, %s\n", 
            rs.getInt("bno"),
            rs.getString("title"),
            rs.getString("content"),
            rs.getInt("views"),
            rs.getDate("cre_dt").toString());
      }
 
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try{rs.close();}catch (Exception e){}
      try{stmt.close();}catch(Exception e){}
      try{con.close();}catch(Exception e){}
    }
  }
}
