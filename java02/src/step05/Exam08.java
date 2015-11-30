/*
 * 주제: 인슽ㄴ스 변수를 초기화 시키는 간결한 방법 
 * - 생성자 (메서드) 
 */
package step05;

public class Exam08 {
  
  static class Score {
    String name;
    int[] subjects = new int[5];
    int sum;
    float aver;

    // 기본 생성자 생략
    // - 컴파일러가 자동으로 기본 생성자를 추가한다.
    //public Score() {}
  }
  public static void main(String[] args) {
    // 그래서 생성자를 만들지 않았음에도 불구하고,
    // 다음과 같이 기본 생성자를 호출할 수 있는 것이다.
    new Score();
  }
}
