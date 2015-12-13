package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Contents;


public interface ContentsDao {

  List<Contents> selectList(Map<String, Object> paramMap);
  
  int insert(Contents contents);
  
  int delete(Map<String, Object> paramMap);
  
  int update(Contents contents);

  Contents selectOne(int cno);

	List<Contents> paging();

	int addViews(int no);

}
