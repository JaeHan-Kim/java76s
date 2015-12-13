package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Contents;


public interface ContentsDao {

  public List<Contents> selectList(Map<String, Object> paramMap);
  
  public int insert(Contents contents);
  
  public int delete(Map<String, Object> paramMap);
  
  public int update(Contents contents);

  public Contents selectOne(int no);

	public List<Contents> paging();

}
