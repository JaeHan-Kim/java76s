package step14.ex08;

import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStream {
  FileInputStream inputstream;
  byte[] buffer = new byte[8094];
  int len;
  int cursor;
  
  public BufferedInputStream(FileInputStream inputstream) throws Exception{
    this.inputstream = inputstream;
  }
  
  public int read() throws IOException {
    if (cursor == len) {  // 버퍼가 비었으면 다시 채운다.
      cursor = 0;
      if((len = inputstream.read(buffer)) == -1) // 파일 끝에 도달하면 -1을 리턴한다.
       return -1; 
    }
    return 0x000000ff & buffer[cursor++];
  }
  
  public void close() throws IOException {
    inputstream.close();
  }
  
}
