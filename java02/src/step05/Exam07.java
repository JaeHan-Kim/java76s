/*
 * 주제: 인슽ㄴ스 변수를 초기화 시키는 간결한 방법 
 * - 생성자 (메서드) 
 */
package step05;

public class Exam07 {
  
  static class Score {
    String name;
    int[] subjects = new int[5];
    int sum;
    float aver;

    public Score() {
      System.out.println("Score 호출");
    }
  }
  public static void main(String[] args) {
    new Score();
    new Score();
    new Score();

  }
}
