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
import java76.pms.domain.Project;
import java76.pms.exception.DaoException;
import java76.pms.util.DBConnectionPool;

@Component
public class ProjectDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  public ProjectDao() {}
  SqlSessionFactory sqlSessionFactiory;

  public void setSqlsessionFactiory(SqlSessionFactory sqlSessionFactiory) {
    this.sqlSessionFactiory = sqlSessionFactiory;
  }
  public List<Project> selectList() {
    SqlSession sqlSession = sqlSessionFactiory.openSession();
    try {
      return sqlSession.selectList("java76.pms.dao.ProjectDao.selectList");
    }  finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
  public int insert(Project project) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.insert("java76.pms.dao.ProjectDao.insert", project);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }

  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.delete("java76.pms.dao.ProjectDao.delete", no);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
  
  public int update(Project project){
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.insert("java76.pms.dao.ProjectDao.update", project);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
}
