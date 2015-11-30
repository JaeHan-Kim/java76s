package library.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import library.annotation.Component;
import library.dao.BookDao;
import library.domain.Book;

@Component("/book/detail")
public class BookDetailServlet implements Servlet{
  BookDao bookDao = null;
  public void setBookDao(BookDao bookdao) {
    this.bookDao = bookdao;
  }
  @Override
  public void service(HashMap<String, Object> params) {
    int no = Integer.parseInt((String)params.get("no"));

    PrintStream out = (PrintStream)params.get("out");
    Book book = bookDao.detail(no).get(0);
        out.printf(" 제목: %s \n 저자: %s \n 출판사: %s \n 태그 %s \n", 
            book.getTitle(),
            book.getAuthors(),
            book.getPress(),
            book.getTag());

  }
}
