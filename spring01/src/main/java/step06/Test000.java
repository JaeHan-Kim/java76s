package step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test000 {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step06/application-context0000.xml");

   System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("c2"));
  }
  
}


