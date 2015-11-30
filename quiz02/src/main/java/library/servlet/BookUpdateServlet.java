package library.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.dao.BookDao;
import library.domain.Book;

@Component("/book/update")
public class BookUpdateServlet implements Servlet{
  @Autowired
  BookDao bookDao = null;
  @Override
  public void service(HashMap<String, Object> params) {
    Book book = new Book();
    PrintStream out = (PrintStream)params.get("out");
    book.setTitle((String)params.get("title"));
    book.setPress((String)params.get("press"));
    book.setAuthors((String)params.get("authors"));
    book.setTag((String)params.get("tag"));
    book.setNo(Integer.parseInt((String)params.get("no")));
    if (bookDao.update(book) > 0) {
      out.println("변경되었습니다.");
    } else {
      out.println("해당 도서가 존재하지 않습니다..");
    }
  }
}
