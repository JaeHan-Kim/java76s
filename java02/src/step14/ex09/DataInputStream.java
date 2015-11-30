package step14.ex09;

import java.io.IOException;
import java.io.InputStream;

public class DataInputStream extends InputStream {
  InputStream inputstream;
  
  public DataInputStream(InputStream inputstream) throws Exception{
    this.inputstream = inputstream;
  }
  public int readInt() throws Exception {
    int i = 0;
    i |= inputstream.read() << 24;
    i |= inputstream.read() << 16;
    i |= inputstream.read() << 8;
    i |= inputstream.read();
    return i;
  }
  public String readUTF() throws Exception{
    int len = 0;
    len |= inputstream.read() << 8;
    len |= inputstream.read();
    
    byte[] bytes = new byte[len];
    inputstream.read(bytes);
    return new String(bytes);
  }
  public void close() throws IOException {
    // 이 클래스에서 해제할 자원이 있다면 여기 밑에 작성하라!
  }
  public int read() throws IOException {
    return inputstream.read();
  }
}
