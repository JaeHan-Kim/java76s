/*
 * 주제: 전위 증/감 후위 증/감
 */
package step02;

public class Exam07 {
  public static void main(String[] args) {
    int i;

    //1) 전위 연산자의 동작 원리
    //- 변수의 값을 먼저 증가시킨 후 그 자리에 현재 변수 값을 놓는다.
    i = 10;
    System.out.println(++i);
    
    //2) 후위 연산자의 동작 원리
    //- 변수의 현재 값을 그 자리에 놓은 후, 변수의 값을 증가시킨다.
    i = 10;
    System.out.println(i++);
    System.out.println(i);
    System.out.println();
    
    //3) 후위 연산자 사례
    i = 10;
    i = i++;
    System.out.println(i);
    System.out.println("---------");
    //4) 여러 개의 전위 연산자
    int r;
    i = 10;
    r = ++i + ++i - ++i * ++i;
    System.out.println(r);
    
    i = 10;
    r= i++ + i++ - i++ * i++;
    System.out.println(r);
    System.out.println(i);
    System.out.println("---------");
    
    i = 10;
    i++;
    System.out.println(i);
    
    i = 10;
    ++i;
    System.out.println(i);
    System.out.println("---------");
    
    i = 10;
    test(++i);
    
    i = 10;
    test(i++);
  }
  
  static void test (int a){
    System.out.println(a);
  }
}
