package library.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.domain.Book;

@Component
public class BookDao implements Serializable{
  private static final long serialVersionUID = 1L;
  @Autowired
  SqlSessionFactory sqlSessionFactiory;

  public BookDao() {}

  public List<Book> selectList(int pageNo, int pageSize, String keyword, String align) {
    SqlSession sqlSession = sqlSessionFactiory.openSession();
    try {
      HashMap<String, Object> paramMap = new HashMap<>();
      paramMap.put("startIndex", (pageNo - 1) * pageSize);
      paramMap.put("length", pageSize);
      paramMap.put("keyword", keyword);
      paramMap.put("align", align);
      return sqlSession.selectList("library.dao.BookDao.selectList", paramMap);
    }
    finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }


  public int insert(Book book) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.insert("library.dao.BookDao.insert", book);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }

  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try{
      return sqlSession.delete("library.dao.BookDao.delete", no);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }

  public int update(Book book){
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.update("library.dao.BookDao.update", book);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
  public List<Book> detail(int no) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.selectList("library.dao.BookDao.detail", no);
    }
    finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }

  public int rent(int no) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.update("library.dao.BookDao.rent", no);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
  public int returnBook(int no) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.update("library.dao.BookDao.returnBook", no);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
}
