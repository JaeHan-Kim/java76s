package step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step08/application-context06.xml");
    // monitor 프로퍼티에 주입할 객체가 여러 개라서 오류 발생 
    // => 해결책? 어떤 객체를 주입할 지 지정하라!
    
    System.out.println(context.getBean("c1"));
    String[] names = context.getBeanDefinitionNames();
    
    // 스프링 IoC 컨테이너에 들어있는 객체를 출력하기
    for (String name : names) {
      System.out.printf("%s:%s\n",name, 
          context.getBean(name).getClass().getName());
    }
  }
} 
