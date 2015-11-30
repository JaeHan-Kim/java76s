package step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step06/application-context03.xml");
    // 리턴 값을 저장
    // getBean()을 호출할 때, 
    System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("c2"));
    System.out.println(context.getBean("c3"));
    
  }
}
