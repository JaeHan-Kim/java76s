package step15.ex04;

public class Test02 {
  public static void main(String[] args) {
    try {
      int result = Calculator2.divide(10, 0);
      System.out.println(result);
    } catch (CalculatorException e) {
      System.out.println(e.getMessage());
    }
  }
}
