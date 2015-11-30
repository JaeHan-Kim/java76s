package library.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.dao.BookDao;

@Component("/book/return")
public class BookReturnServlet implements Servlet{
  @Autowired
  BookDao bookDao = null;
  @Override
  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    int no = Integer.parseInt((String)params.get("no"));
  if (bookDao.returnBook(no) > 0) {
    out.println("반납 되었습니다.");
  } else {
    out.println("이미 반납된 도서이거나 존재하지 않는 도서 입니다.");
  }
  }
}
