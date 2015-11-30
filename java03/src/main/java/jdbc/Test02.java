package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test02 {
  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java76db","java76", "1111");
      
      System.out.println("DBMS 연결 성공!");
      stmt = con.createStatement();
      System.out.println("SQL 실행 객체 준비 완료!");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try{con.close();}catch(Exception e){}
    }
  }
}
