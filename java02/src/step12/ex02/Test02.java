package step12.ex02;

import java.lang.reflect.Modifier;

public class Test02 {

  static class Student {
    // public static Class class; // 내장 변수(Built-in Var.)
    public static String count; // "클래스 변수", "스태틱 변수"
    String name;
    String tel;
 
    @Override
    public String toString() {
      return "Student [name=" + name + ", tel=" + tel + "]";
    }
  }
  public static void main(String[] args) throws Exception{
    
    // class 객체를 얻는 또다른 방법
    // Class classInfo2 = Class.forName("step12.ex02.Test01$Student");
    Class classInfo2 = Student.class;
    Student student = (Student)classInfo2.newInstance();
    student.name = "홍길동";
    student.tel = "111-1111";

    System.out.println(student);
  }
}
