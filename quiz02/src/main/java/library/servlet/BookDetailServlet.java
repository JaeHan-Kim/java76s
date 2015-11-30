package library.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.dao.BookDao;
import library.domain.Book;

@Component("/book/detail")
public class BookDetailServlet implements Servlet{
  @Autowired
  BookDao bookDao = null;
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
