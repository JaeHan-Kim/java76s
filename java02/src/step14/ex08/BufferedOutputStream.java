package step14.ex08;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream {
  OutputStream outputstream;
  
  byte[] buffer = new byte[8192];
  int cursor;

  public BufferedOutputStream(OutputStream outputstream) {
    this.outputstream = outputstream;
  }

  public void write(int b) throws IOException {
    if (cursor >= buffer.length ) {
      outputstream.write(buffer);
      cursor = 0;
    }
    buffer[cursor++] = (byte)b;
  }

  public void write(byte[] b) throws IOException {
    for (int i = 0 ; i < b.length; i++) {
      this.write(b[i]);
    }
  }
  
  public void close() throws IOException {
    if (cursor > 0) {
      outputstream.write(buffer, 0, cursor);
    }
    outputstream.close();
  }
 
  public void flush() throws IOException {
    if (cursor > 0) {
      outputstream.write(buffer, 0 , cursor);
      cursor = 0;
    }
  }
}
