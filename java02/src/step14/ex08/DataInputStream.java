package step14.ex08;

import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStream {
  FileInputStream inputstream;
  
  public DataInputStream(FileInputStream inputstream) throws Exception{
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
    inputstream.close();
  }
}
