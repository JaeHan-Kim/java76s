package step15.ex02;

public class Test03 {
  public static void main(String[] args) {
    // 하위 메서드에서 최상위 메서드로 오류를 전달하기 : 스텔스 기법
    // m4() --> main()
    // => 방법?
    // Throwable 대신 그 하위 클래스인 Error를 던진다.
    try {
      m1();
      } catch (Throwable err) {
        System.out.println(err.getMessage());
      }
  }
  
  public static void m1() {
    m2();
  }
  public static void m2() {
    m4();
  }
  public static void m3() {
    m4();
  }
  public static void m4() {
    // throw new Error("오류!!!");
    throw new RuntimeException("오호라.. 애플리케이션 스텔스 모드 예외.");
  }
}
