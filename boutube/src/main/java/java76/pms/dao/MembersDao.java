package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Users;

public interface MembersDao {

  public List<Users> selectList(Map<String, Object> paramMap);
 
  public int insert(Users members);

  public int delete(String email);
  
  public int update(Users members);
 
  public Users selectOne(String email);

  public Users createToDoList(String email);

  public Users login(Map<String, Object> paramMap);
}
