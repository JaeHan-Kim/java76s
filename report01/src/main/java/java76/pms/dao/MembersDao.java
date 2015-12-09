package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Members;

public interface MembersDao {

  public List<Members> selectList(Map<String, Object> paramMap);
 
  public int insert(Members members);

  public int delete(String email);
  
  public int update(Members members);
 
  public Members selectOne(String email);

  public Members createToDoList(String email);

  public Members login(Map<String, Object> paramMap);
}
