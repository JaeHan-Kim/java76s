/*
 * 주제 : 반목문 - for 
 */
package step03;

public class Exam06 {
  public static void main(String[] args) {
    
    // for (초기화 문장; 조건문; 증가 또는 감소문)
    // 실행 순서
    // 1) 초기화 문장 수행
    // 2) 조건문: 참이면 반복, 거짓이면 반복 종료
    // 3) 명령문 실행
    // 4) 증가 또는 감소 문장 실행 -> 2)번으로 간다.
    for (int i = 0; i < 10; i++)
      System.out.println(i);
  }
}