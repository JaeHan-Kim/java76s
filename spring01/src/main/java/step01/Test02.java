package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step01/application-context02.xml");
   
    Computer c1 = (Computer)context.getBean("c1");
    System.out.println(c1);
  }
}
