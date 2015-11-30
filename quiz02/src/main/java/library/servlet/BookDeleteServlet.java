package library.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.dao.BookDao;
@Component("/book/delete")
public class BookDeleteServlet implements Servlet{
  @Autowired
  BookDao bookDao = null;
  @Override
  public void service(HashMap<String, Object> params) {
    int no = Integer.parseInt((String)params.get("no"));
    
    PrintStream out = (PrintStream)params.get("out");
    
    if (bookDao.delete(no)>0) {
      out.println("삭제하였습니다.");
    } else {
      out.println("해당 번호의 도서가 존재하지 않습니다.");
    }
  }

}
