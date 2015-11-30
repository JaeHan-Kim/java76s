package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step01/application-context05.xml");

    System.out.println("빈의 이름을 알아내기");
    for (String name : context.getBeanDefinitionNames()){
      System.out.println(name);
    }
    
    System.out.println("특정 빈의 별명을 알아내기");
    for (String name : context.getAliases("step01.Computer#0")){
      System.out.println(name);
    }
  }
}
