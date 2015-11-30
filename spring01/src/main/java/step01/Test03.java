package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  public static void main(String[] args) throws Exception{
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step01/application-context03.xml");
    
    System.out.println("빈의 이름을 알아내기");
    for (String name : context.getBeanDefinitionNames()){
      System.out.println(name);
    }
    
    System.out.println("특정 빈의 별명을 알아내기");
    for (String name : context.getAliases("c5")){
      System.out.println(name);
    }
    
    System.out.println("특정 타입의 빈 알아내기");
    //Class<?> classInfo = Class.forName("step01.Computer");
    //Class<?> classInfo = step01.Computer.class;
    for (String name :  context.getBeanNamesForType(step01.Computer.class)) {
      System.out.println(name);
    }
  }
}
