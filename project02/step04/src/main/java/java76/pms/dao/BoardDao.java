package java76.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java76.pms.annotation.Component;
import java76.pms.domain.Board;


@Component
public class BoardDao {
  SqlSessionFactory sqlSessionFactiory;

  public void setSqlsessionFactiory(SqlSessionFactory sqlSessionFactiory) {
    this.sqlSessionFactiory = sqlSessionFactiory;
  }
  public BoardDao() {}
  public List<Board> selectList() {
    SqlSession sqlSession = sqlSessionFactiory.openSession();
    try {
      // selectList()에 주는 값은,
      // SQL 맴퍼 파일에 정의된 namespace 이름
      return sqlSession.selectList("java76.pms.dao.BoardDao.selectList");
      // 굳이 예외를 받지 않는다.
      // selectList()가 던지는 RuntimeExcepion 예외를 그대로 호풀자에게 위임할 것이다.
    }  finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
  
  public int insert(Board board) {
    // auto-commit 활성화 한다.
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.insert("java76.pms.dao.BoardDao.insert", board);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
  
  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.delete("java76.pms.dao.BoardDao.delete", no);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
  
  public int update(Board board){
    SqlSession sqlSession = sqlSessionFactiory.openSession(true);    
    try {
      return sqlSession.insert("java76.pms.dao.BoardDao.update", board);
    } finally {
      try{sqlSession.close();}catch (Exception e){}
    }
  }
}
