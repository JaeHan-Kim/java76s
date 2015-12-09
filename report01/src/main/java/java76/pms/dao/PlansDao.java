package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Plans;


public interface PlansDao {

  public List<Plans> selectList(Map<String, Object> paramMap);
  
  public int insert(Plans plans);
  
  public int delete(Map<String, Object> paramMap);
  
  public int update(Plans plans);

  public Plans selectOne(int no);

}
