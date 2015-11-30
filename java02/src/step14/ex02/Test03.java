package step14.ex02;

public class Test03 {

  public static void main(String[] args) {
    System.out.println(sigma(10));
  }
  public static int sigma(int n) {
    if(n == 1)
      return n;
    return n + sigma(n-1);
  }
}
