/*
 * 주제: 레퍼런스와 인스턴스의 관계
 */
package step04;

public class Exam10 {
  
  // 클래스는 메모리를 준비하는 것이 아니다..
  // 어떤 메모리를 준비해야 하는지를 가르키는 설계도이다.
  // => 사용자 정의 데이터 타입
  static class Score {
    String name;
    int[] subjects = new int[5];
    int sum;
    float aver;
  }
  
  public static void main(String[] args) {
    // Score 인스턴스를 저장할 변수 선언
    // => Score 인스턴스?
    Score v1;
    
    // 주소를 저장할 변수를 초기화시키기 => 모든 비트를 0으로 설정하기
    // v1 = 0; //
    v1 = null; // 주소 변수를 초기화 시키는 특별한 값 null을 사용한다.
    
    // 인스턴스 생성
    // 
    new Score();  // 이 인스턴스는 주소를 보관하지 않았기 때문에 나중에 사용할 수 없다.
    v1 = new Score(); // 이 인스턴스의 주소는 v1 변수에 보관되어 있다.

    v1.name = "홍길동";
    
    // Score v2 = null;
    //  v2.name = "오호라"; // 컴파일 할때는 오류가 발생하지 않는다. 실행할 때 오류 발생!
  
    // 레퍼런스 변수 활용
    Score v3;
    v3 = v1;
    v3.name = "임꺽정";
    System.out.println(v1.name);
  }
}
