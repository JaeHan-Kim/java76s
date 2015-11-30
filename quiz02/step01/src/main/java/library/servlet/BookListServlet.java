package library.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import library.annotation.Component;
import library.dao.BookDao;
import library.domain.Book;

@Component("/book/list")
public class BookListServlet implements Servlet{
  BookDao bookDao = null;
  public void setBookDao(BookDao bookdao) {
    this.bookDao = bookdao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    out.printf("%-3s %-20s %-3s %-10s\n", 
        "No", "Title", "Authors", "Press");
    for (Book book : bookDao.selectList()) {
      out.printf("%3d %-20s %-10s %-10s\n", 
          book.getNo(), 
          book.getTitle(), 
          book.getAuthors(),
          book.getPress());
    }
  }
}
