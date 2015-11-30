package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test08 {
  public static void main(String[] args) {
    Connection con = null;
    PreparedStatement stmt = null;
    try (
        Scanner keyboard = new Scanner(System.in);
        ){
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java76db","java76", "1111");
      stmt = con.prepareStatement("insert into board(title, content, cre_dt) values(?,?,now())");
      System.out.print("제목?");
      String title = keyboard.nextLine();
      
      System.out.print("내용?");
      String content = keyboard.nextLine();
      stmt.setString(1, title);
      stmt.setString(2, content);
      
      int count = stmt.executeUpdate();
      
      if (count > 0)
        System.out.println("추가 성공!");
      else
        System.out.println("추가 실패!");
    } catch (Exception e) {
      e.getStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
