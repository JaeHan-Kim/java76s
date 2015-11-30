package step14.ex08;

import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStream extends OutputStream {
  OutputStream fileoutputstream;
  public DataOutputStream(OutputStream fileoutputstream) throws Exception{
    this.fileoutputstream = fileoutputstream;
  }
  // 기능 추가
  public void writeInt(int value) throws Exception {
    fileoutputstream.write(value >> 24);
    fileoutputstream.write(value >> 16);
    fileoutputstream.write(value >> 8);
    fileoutputstream.write(value);
  }
  
  public void writeUTF(String str) throws Exception {
    byte[] bytes = str.getBytes();

    fileoutputstream.write(bytes.length >> 8);
    fileoutputstream.write(bytes.length);
    fileoutputstream.write(bytes);
  }
  public void close() throws IOException {
    fileoutputstream.close();
  }
  @Override
  public void write(int b) throws IOException {
    fileoutputstream.write(b);
  }
}
