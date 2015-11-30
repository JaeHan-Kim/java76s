/*
 * 주제: 배열 전용 반복문 
 * - for(변수 : 배열) { ... }
 */
package step04;

public class Exam03 {
  
  public static void main(String[] args) {
    int[] sub = {100,90,100,90,100,0,0}; /// 배열 생성 명령을 생략할 수 있다.

    // 특정 범위만 반복할 때문 다음 방식이 더 낫다
    for (int i = 0; i < 5; i++) {
      sub[5] += sub[i];
    }
    sub[6] = sub[5] / 5;

    // 이 방식은 배열을 시작에서 끝까지 반복한다.
    // 반복할 때 마다 배열에서 한 개의 값을 꺼내 value 변수에 담는다.
    for (int value : sub) {
      System.out.println(value);
    }
  }
}
