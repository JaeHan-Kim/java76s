package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Users;

public interface UsersDao {

  public List<Users> selectList(Map<String, Object> paramMap);
 
  public int insert(Users users);

  public int delete(int uno);
  
  public int update(Users users);
 
  public Users selectOne(int uno);

  public Users createToDoList(String email);

  public Users login(Map<String, Object> paramMap);
}


