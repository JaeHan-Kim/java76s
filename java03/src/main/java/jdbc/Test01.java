package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test01 {
  public static void main(String[] args) {
    Connection con = null;
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java76db","java76", "1111");
      
      System.out.println("DBMS 연결 성공!");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try{con.close();}catch(Exception e){}
    }
  }
}
