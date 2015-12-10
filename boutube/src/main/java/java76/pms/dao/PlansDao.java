package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Contents;


public interface PlansDao {

  public List<Contents> selectList(Map<String, Object> paramMap);
  
  public int insert(Contents plans);
  
  public int delete(Map<String, Object> paramMap);
  
  public int update(Contents plans);

  public Contents selectOne(int no);

}
