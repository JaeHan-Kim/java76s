package step14.ex05;

import java.io.FileInputStream;

public class DataInputStream extends FileInputStream{
  public DataInputStream(String name) throws Exception{
    super(name);
  }
  public int readInt() throws Exception {
    int i = 0;
    i |= this.read() << 24;
    i |= this.read() << 16;
    i |= this.read() << 8;
    i |= this.read();
    return i;
  }
  public String readUTF() throws Exception{
    int len = 0;
    len |= this.read() << 8;
    len |= this.read();
    
    byte[] bytes = new byte[len];
    this.read(bytes);
    return new String(bytes);
  }
}
