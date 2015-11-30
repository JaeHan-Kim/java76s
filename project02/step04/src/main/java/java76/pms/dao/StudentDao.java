package java76.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java76.pms.annotation.Component;
import java76.pms.domain.Student;
import java76.pms.exception.DaoException;
import java76.pms.util.DBConnectionPool;

@Component
public class StudentDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  SqlSessionFactory sqlSessionFactiory;

  public void setSqlsessionFactiory(SqlSessionFactory sqlSessionFactiory) {
    this.sqlSessionFactiory = sqlSessionFactiory;
  }
  
  public StudentDao() {}


  public List<Student> selectList() {
    SqlSession sqlSession = sqlSessionFactiory.openSession();
    try {
      return sqlSession.selectList("java76.pms.dao.StudentDao.selectList");
    }  finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
  public int insert(Student student) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.insert("java76.pms.dao.StudentDao.insert", student);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }

  public int delete(String email) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.delete("java76.pms.dao.StudentDao.delete", email);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
  
  public int update(Student student) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.insert("java76.pms.dao.StudentDao.update", student);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
}
