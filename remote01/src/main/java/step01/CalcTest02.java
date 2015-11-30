package step01;

import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class CalcTest02 {
  public static void main(String[] args) throws Exception{
    HttpGet httReq = new HttpGet("http://localhost:8080/remote01/calc");
    
    httReq.addHeader("x-calc-method", "minus");
    httReq.addHeader("x-calc-a", "10");
    httReq.addHeader("x-calc-b", "20");
    
    CloseableHttpClient httpclient = HttpClients.createDefault();
    CloseableHttpResponse  response = httpclient.execute(httReq);
    
    Gson gson = new Gson();
    
    
    try {
      HttpEntity entity = response.getEntity();
      HashMap<?, ?> map = gson.fromJson(
          EntityUtils.toString(entity), HashMap.class);
      System.out.println(map.get("result"));
    } catch(Exception e) {
      
    } finally {
      response.close();
    }
  }
}
