package library.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import library.annotation.Component;
import library.domain.Book;
import library.exception.DaoException;
import library.util.DBConnectionPool;

@Component
public class BookDao implements Serializable{
  private static final long serialVersionUID = 1L;
  SqlSessionFactory sqlSessionFactiory;

  public void setSqlsessionFactiory(SqlSessionFactory sqlSessionFactiory) {
    this.sqlSessionFactiory = sqlSessionFactiory;
  }
  public BookDao() {}

  public List<Book> selectList() {
    SqlSession sqlSession = sqlSessionFactiory.openSession();
    try {
      return sqlSession.selectList("library.dao.BookDao.selectList");
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
