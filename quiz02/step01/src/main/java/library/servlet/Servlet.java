package library.servlet;

import java.util.HashMap;

public interface Servlet {
  void service(HashMap<String,Object> params);
  
}
