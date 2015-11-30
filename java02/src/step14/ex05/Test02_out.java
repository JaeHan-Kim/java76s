package step14.ex05;

import java.io.FileOutputStream;

public class Test02_out {
  public static void main(String[] args) throws Exception {
    // primitive type 데이터 출력하기
    FileOutputStream out = new FileOutputStream("./test/ex05.test02.dat");
    
  //성적 데이터 출력하기
    String name = "홍길동";
    int kor = 100;
    int eng = 90;
    int math = 80;
    
    out.write(name.getBytes());
    out.write(kor >> 24);
    out.write(kor >> 16);
    out.write(kor >> 8);
    out.write(kor);
    
    out.write(eng >> 24);
    out.write(eng >> 16);
    out.write(eng >> 8);
    out.write(eng);
    
    out.write(math >> 24);
    out.write(math >> 16);
    out.write(math >> 8);
    out.write(math);
    // 이름국어영어수학 순서로 출력하시오!
    out.close();
    
    System.out.println("실행 완료!");
  }
}
