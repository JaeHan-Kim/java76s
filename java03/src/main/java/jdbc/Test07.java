package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test07 {
  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    try(
        Scanner keyboard = new Scanner(System.in);
        ) 
    {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());

      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java76db","java76", "1111");
      stmt = con.createStatement();
      System.out.print("제목?");
      String title = keyboard.nextLine();
      
      System.out.print("내용?");
      String content = keyboard.nextLine();
      int count = stmt.executeUpdate("insert into board(title,content,cre_dt)"+
                    " values('"+ title + "','"+ content +"',now())");
      if (count > 0)
        System.out.println("입력 성공 !");
      else
        System.out.println("입력 실패 ! ! !");
    } catch (Exception e) {
      e.getStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
