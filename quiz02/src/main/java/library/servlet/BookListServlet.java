package library.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.dao.BookDao;
import library.domain.Book;

@Component("/book/list")
public class BookListServlet implements Servlet{
  @Autowired
  BookDao bookDao = null;
  @Override
  public void service(HashMap<String, Object> params) {
    
 // 페이징 처리
    int pageNo = 1;
    int pageSize = 10;
    
    if (params.get("pageNo") != null) {
      pageNo =Integer.parseInt((String)params.get("pageNo"));
    }
    if (params.get("pageSize") != null) {
      pageSize =Integer.parseInt((String)params.get("pageSize"));
    }
    
    // 정렬 처리
    String keyword = "no";
    String align = "desc";
    if (params.get("keyword") != null) {
      keyword = (String)params.get("keyword");
    }
    if (params.get("align") != null) {
      align = (String)params.get("align");
    }
    
    PrintStream out = (PrintStream)params.get("out");
    out.printf("%-3s %-20s %-3s %-10s\n", 
        "No", "Title", "Authors", "Press");
    for (Book book : bookDao.selectList(pageNo, pageSize, keyword, align)) {
      out.printf("%3d %-20s %-10s %-10s\n", 
          book.getNo(), 
          book.getTitle(), 
          book.getAuthors(),
          book.getPress());
    }
  }
}
