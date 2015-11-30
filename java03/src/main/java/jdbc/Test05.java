package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test05 {
  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java76db","java76", "1111");
      stmt = con.createStatement();
      stmt.executeUpdate("update board set title='마바사',content='다사여' where bno=12");
      
      System.out.println("입력 성공!");
    } catch (Exception e) {
      e.getStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
