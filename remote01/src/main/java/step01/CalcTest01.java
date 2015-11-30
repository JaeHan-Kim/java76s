package step01;

import step1.CalculatorStub;

public class CalcTest01 {
  public static void main(String[] args) {
    // Calculator calc;
    CalculatorStub calc = new CalculatorStub("192.168.0.29", 8787);
    
    try {
      System.out.println(calc.plus(10, 20));
      System.out.println(calc.minus(10, 20));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
  }
}
