package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test06 {
  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java76db","java76", "1111");
      stmt = con.createStatement();
      int count = stmt.executeUpdate("delete from board where bno=12");
      if (count > 0)
        System.out.println("삭제 성공!");
      else
        System.out.println("해당 번호의 게시물을 찾을 수 없습니다.");
    } catch (Exception e) {
      e.getStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
